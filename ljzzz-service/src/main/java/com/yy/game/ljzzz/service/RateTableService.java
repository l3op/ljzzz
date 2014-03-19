package com.yy.game.ljzzz.service;

import java.util.List;

import com.yy.game.ljzzz.model.conf.RateTable;

public interface RateTableService {

	List<RateTable> list(int actId, int playerData);
	
	/**
	 * 按权重算法返回一个随机抽出的概率表
	 * @param tables
	 * @return
	 */
	RateTable random(List<RateTable> tables);
}
