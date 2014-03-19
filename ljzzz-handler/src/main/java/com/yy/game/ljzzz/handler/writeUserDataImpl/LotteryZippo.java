package com.yy.game.ljzzz.handler.writeUserDataImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yy.game.ljzzz.constants.KeyConstant;
import com.yy.game.ljzzz.dao.AwardIssueStatuDao;
import com.yy.game.ljzzz.exceptions.AssertHelper;
import com.yy.game.ljzzz.handler.WriteUserData;
import com.yy.game.ljzzz.model.Order;
import com.yy.game.ljzzz.model.PlayerData;
import com.yy.game.ljzzz.model.conf.RateTable;
import com.yy.game.ljzzz.service.ActConfService;
import com.yy.game.ljzzz.service.OrderService;
import com.yy.game.ljzzz.service.PlayerDataService;
import com.yy.game.ljzzz.service.RateTableService;
import com.yy.game.ljzzz.vo.WebParamVO;

@Service
public class LotteryZippo implements WriteUserData {
	@Autowired
	private OrderService orderService;
	@Autowired
	private RateTableService rateTableService;
	@Autowired
	private ActConfService actConfService;
	@Autowired
	private AwardIssueStatuDao awardIssueStatuDao;
	@Autowired
	private PlayerDataService playerDataService;
	
	@Transactional
	@Override
	public Map<String, Object> zippo(WebParamVO param) {
		int awardId = NumberUtils.toInt(param.getParam1(), -1);
		AssertHelper.isPositive(awardId, "奖品ID非法");
		
		int times = NumberUtils.toInt(param.getParam2(), -1);
		AssertHelper.isPositive(times, "抽奖次数非法");
		
		int type = NumberUtils.toInt(param.getParam3(), 0);
		
		PlayerData playerData = playerDataService.getData(param.getYyuid(), param.getActId(), param.getGameId(), param.getServerId(), type);
		AssertHelper.chekcParam(playerData, "用户数据不存在");
		
		int count = orderService.lotteryTimes(playerData.getPdId());
		AssertHelper.isTrue(playerData.getValue() >= count + times, "次数不够抽奖");
		
		// 概率表
		List<RateTable> rates = rateTableService.list(playerData.getActId(), playerData.getValue());
		// 抽取一个奖品
		RateTable table = rateTableService.random(rates);
		// 新增订单
		Order order = orderService.addNewOrder(playerData.getPdId(), table.getAwardId(), 1);

		// 增加奖品发放数量
		boolean isNumberLimit = actConfService.getDiyValue(playerData.getActId(), KeyConstant.isNumberLimit);
		// 奖品数量没有限制 或者 增加数量成功
		AssertHelper.isTrue(!isNumberLimit || awardIssueStatuDao.incr(table.getAwardId(), 1), "增加奖品发放数量失败");

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("order", order);
		return result;
	}

	@Override
	public String flag() {
		return "lottery";
	}

}
