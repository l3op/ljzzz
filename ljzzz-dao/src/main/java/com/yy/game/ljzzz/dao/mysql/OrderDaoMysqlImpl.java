package com.yy.game.ljzzz.dao.mysql;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yy.game.ljzzz.dao.OrderDao;
import com.yy.game.ljzzz.enums.OrderStatu;
import com.yy.game.ljzzz.model.Order;

@Repository
public class OrderDaoMysqlImpl implements OrderDao {
	private static final int TABLE_NUM = 10;
	public static String getTableName(long index) {
		return MessageFormat.format("order_%02d", index%TABLE_NUM);
	}
	
	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private NamedParameterJdbcTemplate npJdbc;
	
	@Override
	public boolean add(Order order) {
		String sql = "insert into " + getTableName(order.getPdid()) + 
				"(oid, pdid, statu, issue_times, award_id, num, issue_info, total_value, create, update) " + 
				" value(:oid, :pdid, :statu, :issue_times, :award_id, :num, :issueInfo, :totalValue, :create, :update);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);
		return npJdbc.update(sql, param) > 0;
	}

	@Override
	public boolean updateIsueFail(String oid, long pdid, OrderStatu statu, Date update) {
		String sql = "update " + getTableName(pdid) + " set statu=?, issue_times=issue_times+1, update=? where oid=? and pdid=?";
		return jdbc.update(sql, statu, update, oid, pdid) > 0;
	}

	@Override
	public boolean updateIssue(String oid, long pdid, String issueInfo,
			int totalValue, Date update) {
		String sql = "update " + getTableName(pdid) + " set statu='COMPLETE', issue_info=?, total_value=?, issue_times=issue_times+1, update=? where oid=? and pdid=?";
		return jdbc.update(sql, issueInfo, totalValue, update, oid, pdid) > 0;
	}

	@Override
	public List<Order> listBy(long pdId) {
		String sql = "select * from " + getTableName(pdId) + " where pdid=?";
		return jdbc.queryForList(sql, Order.class, pdId);
	}

	@Override
	public List<Order> listBy(long pdId, int awardId) {
		String sql = "select * from " + getTableName(pdId) + " where pdid=? and award_id=?";
		return jdbc.queryForList(sql, Order.class, pdId, awardId);
	}

	@Override
	public List<Order> listBy(long pdId, Date from, Date to) {
		String sql = "select * from " + getTableName(pdId) + " where pdid=? and create>=? and create < ?";
		return jdbc.queryForList(sql, Order.class, pdId, from, to);
	}

	@Override
	public int countAwards(long pdId) {
		String sql = "select count(*) from " + getTableName(pdId) + " where pdid=?";
		return jdbc.queryForInt(sql, pdId);
	}

	@Override
	public int countAwards(long pdId, int awardId) {
		String sql = "select count(*) from " + getTableName(pdId) + " where pdid=? and award_id=?";
		return jdbc.queryForInt(sql, pdId, awardId);
	}

	@Override
	public int countAwards(long pdId, Date from, Date to) {
		String sql = "select count(*) from " + getTableName(pdId) + " where pdid=? and create>=? and create < ?";
		return jdbc.queryForInt(sql, pdId, from, to);
	}

}
