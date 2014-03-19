package com.yy.game.ljzzz.dao.mysql;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.TemplateMetaDao;
import com.yy.game.ljzzz.model.conf.TemplateMeta;

@Repository
public class TemplateMetaDaoMysqlImpl implements TemplateMetaDao {
	private static final String TABLE_NAME = "template_meta";
	
	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private NamedParameterJdbcTemplate npJdbc;
	
	@Override
	public TemplateMeta get(Integer mid) {
		String sql = "select * from "+ TABLE_NAME +" where mid=?";
		return jdbc.queryForObject(sql, TemplateMeta.class, mid);
	}

	@Override
	public boolean add(TemplateMeta meta) {
		String sql = "insert into " + TABLE_NAME + "(mid, key, type, description) values(:mid, :key, :type, :description);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(meta);
		return npJdbc.update(sql, param) > 0;
	}

	@Override
	public boolean update(TemplateMeta meta) {
		String sql = "update " + TABLE_NAME + " set key=:key, type=:type, description=:description where mid=:mid";
		SqlParameterSource param = new BeanPropertySqlParameterSource(meta);
		return npJdbc.update(sql, param) > 0;
	}

	@Override
	public boolean delete(Integer key, String opusername, Date lmodify) {
		String sql = "delete from " + TABLE_NAME + " where mid=?";
		return jdbc.update(sql, key) > 0;
	}

}
