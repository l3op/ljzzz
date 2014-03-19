package com.yy.game.ljzzz.exceptions;


public class AssertHelper {

	/**
	 * 参数异常
	 * @param param
	 * @param message
	 */
	public static void chekcParam(Object param, String message) {
		if(param == null) {
			throw new ParamException(message);
		}
	}
	
	/**
	 * 检查逻辑
	 * 抛出条件不符异常
	 * @param condition
	 * @param message
	 */
	public static void isTrue(boolean condition, String message) {
		if(!condition) {
			throw new ConditionExcepiton(message);
		}
	}
	
	public static void isPositive(int num, String message) {
		if(num < 0) {
			throw new ParamException(message);
		}
	}
}
