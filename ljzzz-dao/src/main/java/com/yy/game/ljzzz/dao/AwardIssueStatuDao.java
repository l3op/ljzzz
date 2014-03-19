package com.yy.game.ljzzz.dao;

import java.util.Date;

import com.yy.game.ljzzz.model.AwardIssueStatu;

public interface AwardIssueStatuDao {

	AwardIssueStatu get(Integer awardId);
	
	boolean add(AwardIssueStatu bean);
	
	boolean delete(Integer key, String opusername, Date lmodify);
	
	boolean update(AwardIssueStatu bean);
	
	/**
	 * 奖品发放数量增加
	 * @param awardId
	 * @param num
	 * @return
	 */
	boolean incr(int awardId, int num);
}
