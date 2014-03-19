package com.yy.game.ljzzz.enums;

/**
 * 订单状态
 */
public enum OrderStatu {
	/**等待发放中*/
	WAIT,
	/**等待验证*/
	VERIFY,
	/**验证通过*/
	VERIFED,
	/**完成*/
	COMPLETE,
	/**出错*/
	ERROR,
	/**被回收*/
	GC,
	;
}
