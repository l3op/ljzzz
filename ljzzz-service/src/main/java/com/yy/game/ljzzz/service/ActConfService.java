package com.yy.game.ljzzz.service;

import com.yy.game.ljzzz.model.conf.ActConf;

public interface ActConfService {
	ActConf getConf(int actId);

	/**
	 * 从模板中获取私人定制的数据
	 * @param actId
	 * @param key
	 * @return
	 */
	<T> T getDiyValue(int actId, String key);
	
	/**
	 * 通过活动配置,生成数据来源
	 * @param actId
	 * @param gameId
	 * @param serverId
	 * @return
	 */
	String getConfRefer(int actId, String gameId, String serverId);
}
