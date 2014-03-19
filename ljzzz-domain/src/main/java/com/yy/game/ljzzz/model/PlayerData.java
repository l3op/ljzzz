package com.yy.game.ljzzz.model;

import java.util.Date;

/**
 * 玩家数据
 * @author Administrator
 *
 */
public class PlayerData {
	/**主键*/
	private long pdId;
	/**活动ID, 与yyuid, refer, type组成唯一KEY*/
	private int actId;
	/**玩家ID*/
	private long yyuid;
	/**数据来源, 重置后缀, "", "DDT", "DDT_s1", "DDT_s1_131226"*/
	private String refer;
	/**数据类型*/
	private int type;
	/**数据*/
	private int value;
	/**创建时间*/
	private Date create;
	/**最后更新时间*/
	private Date update;
	
	public long getPdId() {
		return pdId;
	}
	public void setPdId(long pdId) {
		this.pdId = pdId;
	}
	public int getActId() {
		return actId;
	}
	public void setActId(int actId) {
		this.actId = actId;
	}
	public long getYyuid() {
		return yyuid;
	}
	public void setYyuid(long yyuid) {
		this.yyuid = yyuid;
	}
	public String getRefer() {
		return refer;
	}
	public void setRefer(String refer) {
		this.refer = refer;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
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
