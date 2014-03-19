package com.yy.game.ljzzz.dao;

import java.util.Date;

import com.yy.game.ljzzz.model.conf.TemplateMeta;

public interface TemplateMetaDao {

	TemplateMeta get(Integer mid);
	
	boolean add(TemplateMeta meta);
	
	boolean update(TemplateMeta meta);
	
	boolean delete(Integer key, String opusername, Date lmodify);
}
