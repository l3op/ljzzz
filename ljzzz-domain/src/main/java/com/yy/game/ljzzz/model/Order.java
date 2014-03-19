package com.yy.game.ljzzz.model;

import java.util.Date;

import com.yy.game.ljzzz.enums.OrderStatu;

/**
 * 活动订单
 */
public class Order {
	/**订单ID*/
	private String oid;
	/**玩家ID*/
	private long pdid;
	/**订单状态*/
	private OrderStatu statu;
	/**发放次数*/
	private int issueTimes;
	
	/**奖品ID*/
	private int awardId;
	/**发放数量*/
	private int num;
	/**奖品内容,主要用于卡码;优惠券总价*/
	private String issueInfo;
	/**订单总价值*/
	private int totalValue;
	
	private Date create;
	private Date update;
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public long getPdid() {
		return pdid;
	}
	public void setPdid(long pdid) {
		this.pdid = pdid;
	}
	public OrderStatu getStatu() {
		return statu;
	}
	public void setStatu(OrderStatu statu) {
		this.statu = statu;
	}
	public int getIssueTimes() {
		return issueTimes;
	}
	public void setIssueTimes(int issueTimes) {
		this.issueTimes = issueTimes;
	}
	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getIssueInfo() {
		return issueInfo;
	}
	public void setIssueInfo(String issueInfo) {
		this.issueInfo = issueInfo;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	
}
