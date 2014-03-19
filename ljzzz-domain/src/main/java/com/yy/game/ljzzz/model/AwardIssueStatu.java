package com.yy.game.ljzzz.model;

/**
 * 奖品发放状态
 */
public class AwardIssueStatu {
	/**奖品ID*/
	private int awardId;
	/**总准备发放数量*/
	private int total;
	/**现已发放数量*/
	private int issue;
	
	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getIssue() {
		return issue;
	}
	public void setIssue(int issue) {
		this.issue = issue;
	}
	
}
