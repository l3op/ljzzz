package com.yy.game.ljzzz.model.conf;

/**
 * 活动配置模板
 * @author Administrator
 *
 */
public class ActivityTemplate {
	/**与act_conf中type一一对应*/
	private int tid;
	/**类型, 抽奖,兑换,签到,任务 四种*/
	private String type;
	/**子类型, 在上述四种类型下的细分*/
	private String subType;
	/**配置类型描述*/
	private String desc;
	/**template_meta表中mid的集合, 以逗号隔开*/
	private String metas;
	/**权限*/
	private String privilegs;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMetas() {
		return metas;
	}
	public void setMetas(String metas) {
		this.metas = metas;
	}
	public String getPrivilegs() {
		return privilegs;
	}
	public void setPrivilegs(String privilegs) {
		this.privilegs = privilegs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	
}
