package com.yy.game.ljzzz.common;

import groovy.lang.GroovyObject;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类的通用工具类
 * @author Administrator
 *
 */
public class ClassUtil {
	private static final Logger ILOG = LoggerFactory.getLogger(ClassUtil.class);
	
	/**
	 * 通过反射的方法来执行groovy
	 * @param target
	 * @param methodName
	 * @param params
	 * @return
	 */
	public static Map<String, Object> invokeGroovy(GroovyObject target, String methodName, Object params) {
		long start = System.currentTimeMillis();
		@SuppressWarnings("unchecked")
		Map<String, Object> value = (Map<String, Object>)target.invokeMethod(methodName, params);
		// 按此日志来分析接口调用次数,性能来决定是否用纯Java来实现
		ILOG.info("[{}]脚本执行耗时[{}], 结果[{}]", new Object[]{target.getClass(), (System.currentTimeMillis() - start), value});
		return value;
	}
}
