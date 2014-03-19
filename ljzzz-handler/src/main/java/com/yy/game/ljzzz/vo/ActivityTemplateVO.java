package com.yy.game.ljzzz.vo;

import java.util.List;

import com.yy.game.ljzzz.model.conf.TemplateMeta;

public class ActivityTemplateVO {
	/**与act_conf中type一一对应*/
	private int tid;
	/**配置类型描述*/
	private String desc;
	/**权限*/
	private String privilegs;
	
	private List<TemplateMeta> metas;

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
	public String getPrivilegs() {
		return privilegs;
	}
	public void setPrivilegs(String privilegs) {
		this.privilegs = privilegs;
	}
	public List<TemplateMeta> getMetas() {
		return metas;
	}
	public void setMetas(List<TemplateMeta> metas) {
		this.metas = metas;
	}
}
