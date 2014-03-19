package com.yy.game.ljzzz.dao.mysql;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.ActConfDao;
import com.yy.game.ljzzz.model.conf.ActConf;

@Repository
public class ActConfDaoMysqlImpl implements ActConfDao {
	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private NamedParameterJdbcTemplate npJdbc;

	@Override
	public boolean add(ActConf activityConf) {
		String sql = "insert into act_conf values(:actId)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(activityConf);
		return npJdbc.update(sql, param) > 0;
	}

	@Override
	public boolean update(ActConf activityConf) {
		String sql = "update act_conf set xx=:xx where act_id=:actId";
		SqlParameterSource param = new BeanPropertySqlParameterSource(activityConf);
		return npJdbc.update(sql, param) > 0;
	}

	@Override
	public boolean delete(Integer key, String opusername, Date lmodify) {
		String sql = "delete from act_conf where act_id=?" ;
		return jdbc.update(sql, key) > 0;
	}

	@Override
	public ActConf get(Integer actId) {
		String sql = "select * from act_conf where act_id=?";
		return jdbc.queryForObject(sql, ActConf.class, actId);
	}

	@Override
	public List<ActConf> list() {
		String sql = "select * from act_conf";
		return jdbc.queryForList(sql, ActConf.class);
	}

	@Override
	public Map<String, Object> getDiyConfs(int actId) {
		throw new RuntimeException("此实现不支持此接口");
	}

}
