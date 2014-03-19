package com.yy.game.ljzzz.dao;

import groovy.lang.GroovyObject;

import java.util.List;

import com.yy.game.ljzzz.model.conf.GroovySource;

public interface GroovySourceDao {
	/**
	 * 获取源码配置信息
	 * @param className
	 * @return
	 */
	GroovySource get(String className);
	
	/**
	 * 获取源码的实例
	 * @param className
	 * @return
	 */
	GroovyObject getObject(String className);
	
	boolean add(GroovySource groovySource);
	
	boolean update(GroovySource grrGroovySource);
	
	boolean delete(String className);
	
	List<GroovySource> list();
}
