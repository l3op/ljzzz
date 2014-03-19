package com.yy.game.ljzzz.dao.mysql;

import groovy.lang.GroovyObject;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.GroovySourceDao;
import com.yy.game.ljzzz.model.conf.GroovySource;

@Repository
public class GroovySourceDaoMysqlImpl implements GroovySourceDao {

	@Override
	public GroovySource get(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(GroovySource groovySource) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(GroovySource grrGroovySource) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String className) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<GroovySource> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroovyObject getObject(String className) {
		// TODO Auto-generated method stub
		return null;
	}

}
