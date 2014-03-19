package com.yy.game.ljzzz.handler;

import java.util.Map;

import com.yy.game.ljzzz.vo.WebParamVO;

/**
 * 向系统中写入数据
 */
public interface WriteUserData extends Ljzzz {
	
	/**
	 * 所有玩法都要实现此接口
	 * @param param
	 * @return
	 */
	Map<String, Object> zippo(WebParamVO param);
}
