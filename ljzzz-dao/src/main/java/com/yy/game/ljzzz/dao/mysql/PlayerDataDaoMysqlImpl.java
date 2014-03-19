package com.yy.game.ljzzz.dao.mysql;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.PlayerDataDao;
import com.yy.game.ljzzz.enums.DataType;
import com.yy.game.ljzzz.model.PlayerData;

@Repository
public class PlayerDataDaoMysqlImpl implements PlayerDataDao {
	private static final int TABLE_NUM = 10;
	
	public static final String getTableName(long index) {
		return MessageFormat.format("player_data_%02d", index % TABLE_NUM);
	}
	
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public PlayerData get(long yyuid, int actId, String refer, DataType type) {
		String sql = "select * from " + getTableName(yyuid) + " where yyuid=? and act_id=? and refer=? and type=?";
		return jdbc.queryForObject(sql, PlayerData.class, yyuid, actId, refer, type);
	}

}
