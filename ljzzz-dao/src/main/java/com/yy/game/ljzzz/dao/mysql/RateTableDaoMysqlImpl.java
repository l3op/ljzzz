package com.yy.game.ljzzz.dao.mysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.RateTableDao;
import com.yy.game.ljzzz.model.conf.RateTable;

@Repository
public class RateTableDaoMysqlImpl implements RateTableDao {
	private static final String TABLE_NAME = "rate_table";
	
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public boolean add(RateTable table) {
//		InsertBuilder builder = new InsertBuilder(TABLE_NAME);
		String sql = "insert into " + TABLE_NAME + " value(:xx)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(table);
		return jdbc.update(sql, param) > 0;
	}

	@Override
	public boolean update(RateTable table) {
		String sql = "insert into " + TABLE_NAME + " values(:xx)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(table);
		return jdbc.update(sql, param) > 0;
	}

	@Override
	public boolean delete(int actId) {
		String sql = "delete from " + TABLE_NAME + " where act_id=?";
		return jdbc.update(sql, actId) > 0;
	}

	@Override
	public List<RateTable> list(int actId, int value) {
		String sql = "select * from " + TABLE_NAME + " where act_id=? and from<=? and to>?";
		return jdbc.queryForList(sql, RateTable.class, actId, value, value);
	}

	@Override
	public List<RateTable> list(int actId) {
		String sql = "select * from " + TABLE_NAME + " where act_id=?";
		return jdbc.queryForList(sql, RateTable.class, actId);
	}

}
