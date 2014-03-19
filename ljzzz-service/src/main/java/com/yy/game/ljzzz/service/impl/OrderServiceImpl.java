package com.yy.game.ljzzz.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.game.ljzzz.common.IDGenerator;
import com.yy.game.ljzzz.dao.OrderDao;
import com.yy.game.ljzzz.enums.OrderStatu;
import com.yy.game.ljzzz.exceptions.AssertHelper;
import com.yy.game.ljzzz.model.Order;
import com.yy.game.ljzzz.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order addNewOrder(long pdid, int awardId, int num) {
		// 生成订单
		Order order = new Order();
		order.setOid(IDGenerator.orderId());
		order.setPdid(pdid);
		order.setAwardId(awardId);
		order.setNum(num);
		order.setStatu(OrderStatu.WAIT);
		order.setIssueTimes(0);
		
		Date now = new Date();
		order.setCreate(now);
		order.setUpdate(now);
		AssertHelper.isTrue(orderDao.add(order), "保存订单失败");
		return order;
	}

	@Override
	public int lotteryTimes(long pdid) {
		return orderDao.countAwards(pdid);
	}

}
