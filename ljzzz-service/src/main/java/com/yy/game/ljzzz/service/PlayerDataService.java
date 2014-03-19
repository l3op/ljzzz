package com.yy.game.ljzzz.service;

import com.yy.game.ljzzz.model.PlayerData;

public interface PlayerDataService {

	/**
	 * 获取玩家数据
	 * @param yyuid
	 * @param actId
	 * @param gameId
	 * @param serverId
	 * @param type
	 * @return
	 */
	PlayerData getData(long yyuid, int actId, String gameId, String serverId, int type);
}
