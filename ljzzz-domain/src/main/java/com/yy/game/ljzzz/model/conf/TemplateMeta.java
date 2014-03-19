package com.yy.game.ljzzz.model.conf;

import com.yy.game.ljzzz.enums.MetaType;

/**
 * 模板元信息
 * @author Administrator
 *
 */
public class TemplateMeta {
	/**meta id*/
	private int mid;
	/**配置KEY, 配置Value放在ActConf中*/
	private String key;
	/**类型*/
	private MetaType type;
	/**配置描述*/
	private String description;
	/**默认值*/
	private String defaultValue;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public MetaType getType() {
		return type;
	}
	public void setType(MetaType type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
