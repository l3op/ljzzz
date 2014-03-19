package com.yy.game.ljzzz.dao;

import java.util.List;

import com.yy.game.ljzzz.model.conf.RateTable;

public interface RateTableDao {

	boolean add(RateTable table);
	
	boolean update(RateTable table);
	
	boolean delete(int actId);
	
	/**
	 * 根据用户的数据来选择相应的概率表
	 * @param actId
	 * @param value
	 * @return
	 */
	List<RateTable> list(int actId, int value);
	
	/**
	 * 查询指定活动的所有概率表
	 * 用于后台
	 * @param actId
	 * @return
	 */
	List<RateTable> list(int actId);
}
