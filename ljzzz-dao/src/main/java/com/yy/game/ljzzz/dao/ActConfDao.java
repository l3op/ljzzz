package com.yy.game.ljzzz.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yy.game.ljzzz.model.conf.ActConf;

/**
 * 活动配置的操作接口
 * @author Administrator
 *
 */
public interface ActConfDao {

	/**
	 * actId自增
	 * @param activityConf
	 * @return
	 */
	boolean add(ActConf activityConf);
	
	boolean update(ActConf activityConf);
	
	boolean delete(Integer key, String opusername, Date lmodify);
	
	ActConf get(Integer actId);

	List<ActConf> list();
	
	Map<String, Object> getDiyConfs(int actId);
}
