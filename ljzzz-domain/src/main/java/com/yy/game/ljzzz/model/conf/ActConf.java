package com.yy.game.ljzzz.model.conf;

import java.util.Date;

import com.yy.game.ljzzz.enums.ActConfStatu;
import com.yy.game.ljzzz.enums.DataLevel;

/**
 * 活动配置
 */
public class ActConf {
	private int actId;
	/**活动类型*/
	private int type;
	
	/**活动开始时间*/
	private Date start;
	/**活动的数据拉取结束时间, 如果不填,默认取活动结束前1个小时*/
	private Date endPull;
	/**活动结束时间*/
	private Date end;
	/**活动状态, 测试, 上线, 暂停*/
	private ActConfStatu statu;
	/**暂停时的提示语*/
	private String prompt;
	
	/**
	 * 玩一次要多少钱
	 * 充值与消费
	 * 其它类型的放在other中
	 */
	private int ratio;
	/**数据级别*/
	private DataLevel dataLevel;
	/**其它个性配置K-V健值对, 以json格式序例化*/
	private String other;

	public int getActId() {
		return actId;
	}
	public void setActId(int actId) {
		this.actId = actId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEndPull() {
		return endPull;
	}
	public void setEndPull(Date endPull) {
		this.endPull = endPull;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public ActConfStatu getStatu() {
		return statu;
	}
	public void setStatu(ActConfStatu statu) {
		this.statu = statu;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public int getRatio() {
		return ratio;
	}
	public void setRatio(int ratio) {
		this.ratio = ratio;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public DataLevel getDataLevel() {
		return dataLevel;
	}
	public void setDataLevel(DataLevel dataLevel) {
		this.dataLevel = dataLevel;
	}
}
