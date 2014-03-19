package com.yy.game.ljzzz.dao;

import java.util.Date;
import java.util.List;

import com.yy.game.ljzzz.model.conf.ActivityTemplate;

public interface ActivityTemplateDao {

	boolean add(ActivityTemplate template);
	
	boolean update(ActivityTemplate template);
	
	boolean delete(Integer key, String opusername, Date lmodify);
	
	ActivityTemplate get(Integer tid);
	
	List<ActivityTemplate> list();
}
