package com.yy.game.ljzzz.handler;

import java.util.Map;

import com.yy.game.ljzzz.vo.WebParamVO;

/**
 * 查询数据,不需要登录
 * 可能是配置信息,动态,排行榜等
 */
public interface ReadData extends Ljzzz {
	
	/**
	 * @param param
	 * @return
	 */
	Map<String, Object> readData(WebParamVO param);
}
