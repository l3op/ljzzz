package com.yy.game.ljzzz.exceptions;

/**
 * 参数非法异常
 * @author Administrator
 *
 */
public class ParamException extends RuntimeException{
	private static final long serialVersionUID = 8242051346925012603L;

	public ParamException() {
		super();
	}
	
	public ParamException(String message) {
		super(message);
	}
	
	public ParamException(Throwable th, String message) {
		super(message, th);
	}
}
