package com.yy.game.ljzzz.dao;

import com.yy.game.ljzzz.enums.DataType;
import com.yy.game.ljzzz.model.PlayerData;

public interface PlayerDataDao {

	/**
	 * 查询
	 * @param yyuid
	 * @param actId
	 * @param refer
	 * @param type
	 * @return
	 */
	PlayerData get(long yyuid, int actId, String refer, DataType type);
}
