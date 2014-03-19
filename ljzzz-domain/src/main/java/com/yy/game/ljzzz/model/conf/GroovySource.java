package com.yy.game.ljzzz.model.conf;

import java.util.Date;

/**
 * groovy代码
 */
public class GroovySource {
	/**类名*/
	private String className;
	/**描述*/
	private String desc;
	/**代码内容*/
	private String source;
	/**创建者*/
	private String creater;
	/**创建时间*/
	private Date create;
	/**修改者*/
	private String updater;
	/**修改时间*/
	private Date update;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
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
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	@Override
	public String toString() {
		return "GroovySource [className=" + className + ", desc=" + desc
				+ ", source=" + source + ", creater=" + creater + ", create="
				+ create + ", updater=" + updater + ", update=" + update + "]";
	}
	
	
}
