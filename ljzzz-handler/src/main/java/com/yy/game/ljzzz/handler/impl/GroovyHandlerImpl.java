package com.yy.game.ljzzz.handler.impl;

import groovy.lang.GroovyObject;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yy.game.ljzzz.dao.GroovySourceDao;
import com.yy.game.ljzzz.exceptions.AssertHelper;
import com.yy.game.ljzzz.handler.GroovyHandler;
import com.yy.game.ljzzz.vo.WebParamVO;

@Component
public class GroovyHandlerImpl implements GroovyHandler {
	private static final Logger ILOG = LoggerFactory.getLogger(GroovyHandlerImpl.class);
	
	/**
	 * JVM缓存实现
	 */
	@Autowired
	private GroovySourceDao groovySourceCacheImpl;
	
	@Override
	public Map<String, Object> doByGroovy(String ifaceName, String methodName, WebParamVO param) {
		GroovyObject target = groovySourceCacheImpl.getObject(ifaceName + "_" + methodName);
		AssertHelper.isTrue(target != null, "接口未实现");
		
		long start = System.currentTimeMillis();
		@SuppressWarnings("unchecked")
		Map<String, Object> value = (Map<String, Object>)target.invokeMethod(methodName, param);
		// 按此日志来分析接口调用次数,性能来决定是否用纯Java来实现
		ILOG.info("[{}]脚本执行耗时[{}], 结果[{}]", new Object[]{ifaceName, (System.currentTimeMillis() - start), value});
		return value;
	}

}
