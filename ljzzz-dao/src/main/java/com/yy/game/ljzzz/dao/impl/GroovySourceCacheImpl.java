package com.yy.game.ljzzz.dao.impl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.GroovySourceDao;
import com.yy.game.ljzzz.dao.JvmCache;
import com.yy.game.ljzzz.exceptions.ConditionExcepiton;
import com.yy.game.ljzzz.model.conf.GroovySource;

@Repository
public class GroovySourceCacheImpl implements GroovySourceDao, InitializingBean{
	private static final Logger ILOG = LoggerFactory.getLogger(GroovySourceCacheImpl.class);
	
	@Autowired
	private GroovySourceDao groovySourceDaoMysqlImpl;

	private static final GroovyClassLoader CLASS_LOADER = new GroovyClassLoader();
	
	@Resource(name="groovySourceDaoJvmImpl")
	private JvmCache<String, GroovyObject> jvmCache;
	
	@Override
	public GroovySource get(String className) {
		return groovySourceDaoMysqlImpl.get(className);
	}

	@Override
	public boolean add(GroovySource groovySource) {
		return groovySourceDaoMysqlImpl.add(groovySource);
	}

	@Override
	public boolean update(GroovySource grrGroovySource) {
		loadData();
		return groovySourceDaoMysqlImpl.update(grrGroovySource);
	}

	@Override
	public boolean delete(String className) {
		loadData();
		return groovySourceDaoMysqlImpl.delete(className);
	}

	@Override
	public List<GroovySource> list() {
		return groovySourceDaoMysqlImpl.list();
	}

	@Override
	public GroovyObject getObject(String className) {
		try {
			return jvmCache.getInstance(className);
		} catch(ConditionExcepiton ce) {
			loadData();
			return jvmCache.getInstance(className);
		}
	}
	
	void loadData() {
		jvmCache.flush();
		List<GroovySource> sources = groovySourceDaoMysqlImpl.list();
		Map<String, GroovyObject> objects = new HashMap<String, GroovyObject>();
		for(GroovySource source : sources) {
			try {
				Class<?> groovyClass = CLASS_LOADER.parseClass(source.getSource());
				GroovyObject object = (GroovyObject) groovyClass.newInstance();
				objects.put(source.getClassName(), object);
			} catch (Exception e) {
				ILOG.error("groovy数据加载异常, source[" + source + "]", e);
			}
		}
		jvmCache.updateCache(objects);
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		jvmCache.setTimeout(15 * 60);
		
		// 初始化缓存中中数据
		loadData();
	}

}
