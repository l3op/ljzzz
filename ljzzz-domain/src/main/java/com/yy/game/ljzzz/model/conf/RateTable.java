package com.yy.game.ljzzz.model.conf;

/**
 * 奖品概率表
 * @author Administrator
 *
 */
public class RateTable {
	/**概率表*/
	private int actId;
	/**条件起始值*/
	private int from;
	/**条件结束值*/
	private int to;
	/**概率值*/
	private int rate;
	/**奖品ID*/
	private int awardId;
	
	public int getActId() {
		return actId;
	}
	public void setActId(int actId) {
		this.actId = actId;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
}
