package com.yy.game.ljzzz.exceptions;

/**
 * 条件不符异常
 * @author Administrator
 *
 */
public class ConditionExcepiton extends RuntimeException{
	private static final long serialVersionUID = 8421340787756016369L;

	public ConditionExcepiton() {
		super();
	}
	
	public ConditionExcepiton(String message) {
		super(message);
	}
	
	public ConditionExcepiton(Throwable th, String message) {
		super(message, th);
	}
}
