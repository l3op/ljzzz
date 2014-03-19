package com.yy.game.ljzzz.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.ActivityTemplateDao;
import com.yy.game.ljzzz.dao.JvmCache;
import com.yy.game.ljzzz.exceptions.ConditionExcepiton;
import com.yy.game.ljzzz.model.conf.ActivityTemplate;

@Repository
public class ActivityTemplateDaoCacheImpl implements ActivityTemplateDao, InitializingBean {
	
	@Autowired
	private ActivityTemplateDao activityTemplateDaoMysqlImpl;
	@Autowired
	private JvmCache<Integer, ActivityTemplate> jvmCache;
	
	@Override
	public boolean add(ActivityTemplate template) {
		return activityTemplateDaoMysqlImpl.add(template);
	}

	@Override
	public boolean update(ActivityTemplate template) {
		loadData();
		return activityTemplateDaoMysqlImpl.update(template);
	}

	@Override
	public List<ActivityTemplate> list() {
		return activityTemplateDaoMysqlImpl.list();
	}

	@Override
	public boolean delete(Integer key, String opusername, Date lmodify) {
		loadData();
		return activityTemplateDaoMysqlImpl.delete(key, opusername, lmodify);
	}

	@Override
	public ActivityTemplate get(Integer tid) {
		try {
			return jvmCache.getInstance(tid);
		} catch(ConditionExcepiton ce) {
			// jvm中数据过期
			loadData();
			return jvmCache.getInstance(tid);
		}
	}
	
	void loadData() {
		jvmCache.flush();
		List<ActivityTemplate> templates = activityTemplateDaoMysqlImpl.list();
		Map<Integer, ActivityTemplate> data = new HashMap<Integer, ActivityTemplate>();
		for(ActivityTemplate template : templates) {
			data.put(template.getTid(), template);
		}
		jvmCache.updateCache(data);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		jvmCache.setTimeout(15 * 60);
		loadData();
	}

}
