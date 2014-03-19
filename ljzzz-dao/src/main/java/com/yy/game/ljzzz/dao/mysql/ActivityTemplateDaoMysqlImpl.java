package com.yy.game.ljzzz.dao.mysql;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.ActivityTemplateDao;
import com.yy.game.ljzzz.model.conf.ActivityTemplate;

@Repository
public class ActivityTemplateDaoMysqlImpl implements ActivityTemplateDao {
	public static final String TABLE = "template";
	
	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private NamedParameterJdbcTemplate npJdbc;

	@Override
	public boolean add(ActivityTemplate template) {
		String sql = "insert into " + TABLE + "(tid, desc, metas) values(:tid, :desc, :metas)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(template);
		return npJdbc.update(sql, param) > 0;
	}

	@Override
	public boolean update(ActivityTemplate template) {
		String sql = "update " + TABLE + " set desc=:desc, metas=:metas where tid=:tid";
		SqlParameterSource param = new BeanPropertySqlParameterSource(template);
		return npJdbc.update(sql, param) > 0;
	}

	@Override
	public boolean delete(Integer tid, String opusername, Date lmodify) {
		String sql = "delete from " + TABLE + " where tid=?";
		return jdbc.update(sql, tid) > 0;
	}

	@Override
	public ActivityTemplate get(Integer tid) {
		String sql = "select * from " + TABLE + " wheer tid=?";
//		return jdbc.query(sql, ActivityTemplate.class, tid);
		return jdbc.queryForObject(sql, ActivityTemplate.class, tid);
	}

	@Override
	public List<ActivityTemplate> list() {
		String sql = "select * from " + TABLE;
		return jdbc.queryForList(sql, ActivityTemplate.class);
	}

}
