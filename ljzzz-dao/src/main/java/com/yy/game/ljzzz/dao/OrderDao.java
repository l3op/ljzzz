package com.yy.game.ljzzz.dao;

import java.util.Date;
import java.util.List;

import com.yy.game.ljzzz.enums.OrderStatu;
import com.yy.game.ljzzz.model.Order;

public interface OrderDao {

	/**
	 * 新增一订单
	 * @param order
	 * @return
	 */
	boolean add(Order order);
	
	/**
	 * 当发放失败后,更新订单相应信息
	 * @param oid
	 * @param pdid
	 * @param update
	 * @return
	 */
	boolean updateIsueFail(String oid, long pdid, OrderStatu statu, Date update);
	
	/**
	 * 当订单发放成功后,更新发放内容
	 * @param oid
	 * @param pdid
	 * @param issueInfo
	 * @param totalValue
	 * @param update
	 * @return
	 */
	boolean updateIssue(String oid, long pdid, String issueInfo, int totalValue, Date update);
	
	/**
	 * 查询指定用户ID的所有订单
	 * @param pdId
	 * @return
	 */
	List<Order> listBy(long pdId);
	
	/**
	 * 按指定的奖品ID来查询
	 * 用于兑换
	 * @param pdId
	 * @param awardId
	 * @return
	 */
	List<Order> listBy(long pdId, int awardId);
	
	/**
	 * 在指定时间之内增加的订单
	 * 用于签到记录
	 * @param pdId
	 * @param from
	 * @param to
	 * @return
	 */
	List<Order> listBy(long pdId, Date from, Date to);
	
	/**
	 * 统计获得奖品数量
	 * 用于抽奖已经次数
	 * @param pdId
	 * @return
	 */
	int countAwards(long pdId);
	
	/**
	 * 统计奖品数量
	 * @param pdId
	 * @param awardId
	 * @return
	 */
	int countAwards(long pdId, int awardId);
	
	/**
	 * 统计在指定时间内获得的奖品数量
	 * 用于判断有无签到
	 * @param pdId
	 * @param from
	 * @param to
	 * @return
	 */
	int countAwards(long pdId, Date from, Date to);
}
