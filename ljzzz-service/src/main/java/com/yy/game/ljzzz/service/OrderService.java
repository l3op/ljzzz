package com.yy.game.ljzzz.service;

import com.yy.game.ljzzz.model.Order;

public interface OrderService {

	/**
	 * 新增订单
	 * @param pdid
	 * @param awardId
	 * @param num
	 */
	Order addNewOrder(long pdid, int awardId, int num);
	
	/**
	 * 抽奖次数,根据我的抽中的奖品数量来计算
	 * @param pdid
	 * @return
	 */
	int lotteryTimes(long pdid);
}
