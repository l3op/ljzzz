package com.yy.game.ljzzz.common;

import org.apache.commons.lang.StringUtils;

/**
 * 活动公共方法
 */
public class ActivityUtil {
	
	/**
	 * 判断ele是否在content中
	 * content的组成格式为a,b,c
	 * @param content
	 * @param ele
	 * @return
	 */
	public static boolean contains(String content, String ele) {
		if(StringUtils.isBlank(content) || StringUtils.isBlank(ele)) {
			return false;
		}
		
		String[] eles = content.split(",");
		for(String e : eles) {
			if(e.equals(ele)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 从content中移除ele
	 * content的组成格式为a,b,c
	 * @param content
	 * @param ele
	 * @return
	 */
	public static String remove(String content, String ele) {
		String regex = "^" + ele + ",|," + ele + "$";
		return content.replaceAll(regex, "").replaceAll("," + ele + ",", ",");
	}
}
