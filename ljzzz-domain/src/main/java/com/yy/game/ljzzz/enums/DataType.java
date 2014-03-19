package com.yy.game.ljzzz.enums;

import java.util.HashMap;
import java.util.Map;

public enum DataType {
	/**充值*/
	RECHARGE(0),		
	/**消费*/
	COST(1),
	/**积分, 用于中间货币*/
	INTEGRAL(2),
	/**任务积分*/
	TASK_INTEGRAL(3),
	;
	
	int type;
	private DataType(int t) {
		type = t;
	}
	
	public int getType() {
		return type;
	}
	
	private static Map<Integer, DataType> cache = new HashMap<Integer, DataType>();
	static {
		for(DataType type : DataType.values()) {
			cache.put(type.type, type);
		}
	}
	
	public static DataType getByType(int type) {
		return cache.get(type);
	}
}
