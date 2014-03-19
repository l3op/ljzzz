package com.yy.game.ljzzz.model.conf;

/**
 * 奖品属性信息
 */
public class Award {
	/**奖品ID*/
	private int awardId;
	/**奖品名称*/
	private String name;
	/**奖品类型*/
	private int type;
	/**奖品标识*/
	private int flag;
	/**奖品价值*/
	private int value;
	/**图片地址*/
	private String imgUrl;
	/**权重, 用于在奖品列表中排序*/
	private int weight;
	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
