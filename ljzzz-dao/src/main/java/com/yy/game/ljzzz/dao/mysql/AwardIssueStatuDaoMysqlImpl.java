package com.yy.game.ljzzz.dao.mysql;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.AwardIssueStatuDao;
import com.yy.game.ljzzz.model.AwardIssueStatu;

@Repository
public class AwardIssueStatuDaoMysqlImpl implements AwardIssueStatuDao {

	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private NamedParameterJdbcTemplate npJdbc;
	
	@Override
	public AwardIssueStatu get(Integer awardId) {
		String sql = "select * from issue_statu where award_id=?";
		return jdbc.queryForObject(sql, AwardIssueStatu.class, awardId);
	}

	@Override
	public boolean add(AwardIssueStatu bean) {
		String sql = "insert into issue_statu (award_id, total, issue) values(:awardId, :total, :issue)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(bean);
		return npJdbc.update(sql, param) > 0;
	}

	@Override
	public boolean delete(Integer key, String opusername, Date lmodify) {
		String sql = "delete from issue_statu where award_id=?";
		return jdbc.update(sql, key) > 0;
	}

	@Override
	public boolean update(AwardIssueStatu bean) {
		String sql = "update issue_statu set total=:total, issue=:issue where award_id=:awardId";
		SqlParameterSource param = new BeanPropertySqlParameterSource(bean);
		return npJdbc.update(sql, param) > 0; 
	}

	@Override
	public boolean incr(int awardId, int num) {
		String sql = "update issue_statu set issue=issue+? where award_id=? and total-issue>=?";
		return jdbc.update(sql, num, awardId, num) > 0;
	}

}
