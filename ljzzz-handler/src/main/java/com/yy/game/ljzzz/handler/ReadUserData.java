package com.yy.game.ljzzz.handler;

import java.util.Map;

import com.yy.game.ljzzz.vo.WebParamVO;

/**
 * 查询用户数据
 * 需要用户登录
 */
public interface ReadUserData extends Ljzzz {

	/**
	 * 
	 * @param param
	 * @return
	 */
	Map<String, Object> readUserData(WebParamVO param);
}
