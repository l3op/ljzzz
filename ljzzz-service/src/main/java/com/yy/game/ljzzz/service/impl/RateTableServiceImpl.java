package com.yy.game.ljzzz.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.game.ljzzz.constants.KeyConstant;
import com.yy.game.ljzzz.dao.AwardIssueStatuDao;
import com.yy.game.ljzzz.dao.RateTableDao;
import com.yy.game.ljzzz.model.AwardIssueStatu;
import com.yy.game.ljzzz.model.conf.RateTable;
import com.yy.game.ljzzz.service.ActConfService;
import com.yy.game.ljzzz.service.RateTableService;

@Service
public class RateTableServiceImpl implements RateTableService {
	private static final Random RAND = new Random();

	@Autowired
	private RateTableDao rateTableDao;
	@Autowired
	private ActConfService actConfService;
	@Autowired
	private AwardIssueStatuDao awardIssueStatuDao;
	
	@Override
	public List<RateTable> list(int actId, int playerData) {
		// 按抽奖次数
		List<RateTable> rates = rateTableDao.list(actId, playerData);
		boolean isLimitNum = actConfService.getDiyValue(actId, KeyConstant.isNumberLimit);
		if(!isLimitNum) {
			return rates;
		}
		
		for(Iterator<RateTable> it = rates.iterator(); it.hasNext();) {
			RateTable rate = it.next();
			AwardIssueStatu statu = awardIssueStatuDao.get(rate.getAwardId());
			if(statu.getTotal() <= statu.getIssue()) {
				it.remove();
			}
		}
		
		return rates;
	}

	@Override
	public RateTable random(List<RateTable> tables) {
		int totalRate = 0;
		for(RateTable table : tables) {
			totalRate += table.getRate();
		}
		
		int rate = RAND.nextInt(totalRate);
		int start = 0; 
		int end = 0;
		for(RateTable table : tables) {
			end = table.getRate();
			if(rate >= start && rate < end) {
				return table;
			}
		}
		
		throw new RuntimeException("概率表配置错误,请认真检查配置");
	}

}
