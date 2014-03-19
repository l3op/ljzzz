package com.yy.game.ljzzz.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.common.JsonUtil;
import com.yy.game.ljzzz.dao.ActConfDao;
import com.yy.game.ljzzz.dao.jvm.JvmCacheFacade;
import com.yy.game.ljzzz.exceptions.ConditionExcepiton;
import com.yy.game.ljzzz.model.conf.ActConf;

@Repository
public class ActConfDaoCacheImpl implements ActConfDao, InitializingBean {
	@Autowired
	private ActConfDao actConfDaoMysqlImpl;
	@Autowired
	private JvmCacheFacade<Integer, ActConf> confCache;
	@Autowired
	private JvmCacheFacade<Integer, Map<String,Object>> diyConfCache;
	
	@Override
	public boolean add(ActConf activityConf) {
		return actConfDaoMysqlImpl.add(activityConf);
	}

	@Override
	public boolean update(ActConf activityConf) {
		loadConfData();
		loadDiyConfData();
		return actConfDaoMysqlImpl.update(activityConf);
	}

	@Override
	public boolean delete(Integer key, String opusername, Date lmodify) {
		loadConfData();
		loadDiyConfData();
		return actConfDaoMysqlImpl.delete(key, opusername, lmodify);
	}

	@Override
	public ActConf get(Integer actId) {
		try {
			return confCache.getInstance(actId);
		} catch(ConditionExcepiton ce) {
			loadConfData();
			return confCache.getInstance(actId);
		}
	}

	@Override
	public List<ActConf> list() {
		return actConfDaoMysqlImpl.list();
	}

	void loadConfData() {
		confCache.flush();
		Map<Integer, ActConf> data = new HashMap<Integer, ActConf>();
		for(ActConf actConf : actConfDaoMysqlImpl.list()) {
			data.put(actConf.getActId(), actConf);
		}
		
		confCache.updateCache(data);
	}
	
	@Override
	public Map<String, Object> getDiyConfs(int actId) {
		try {
			return diyConfCache.getInstance(actId);
		} catch(ConditionExcepiton ce) {
			// 数据过期了,再加载一次数据
			loadDiyConfData();
			return diyConfCache.getInstance(actId);
		}
	}
	
	void loadDiyConfData() {
		diyConfCache.flush();
		Map<Integer, Map<String, Object>> data = new HashMap<Integer, Map<String,Object>>();
		for(ActConf conf : actConfDaoMysqlImpl.list()) {
			Map<String, Object> diyConfs = JsonUtil.toMapObject(conf.getOther(), HashMap.class, String.class, Object.class);
			data.put(conf.getActId(), diyConfs);
		}
		
		diyConfCache.updateCache(data);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// 15分钟 更新一次jvmCache
		confCache.setTimeout(15 * 60);
		loadConfData();
		
		diyConfCache.setTimeout(15 * 60);
		loadDiyConfData();
	}

}
