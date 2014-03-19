package com.yy.game.ljzzz.common;

import java.text.MessageFormat;

/**
 * ID生成器
 * @author Administrator
 *
 */
public class IDGenerator {
	private static int count = 0;

	/**
	 * 16位长度的订单ID
	 * @return
	 */
	public static String orderId() {
		return MessageFormat.format("%12s%04d", "yyMMddHHmmss", count++%10000);
	}
}
