package com.yy.game.ljzzz.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据级别
 */
public enum DataLevel {
	PLATFORM(0),		// 平台
	GAME(1),			// 游戏
	SERVER(2),			// 区服
	;
	
	int value;
	private DataLevel(int v) {
		value = v;
	}
	
	public int getValue() {
		return value;
	}
	
	private static Map<Integer, DataLevel> cache = new HashMap<Integer, DataLevel>();
	static {
		for(DataLevel level : DataLevel.values()) {
			cache.put(level.value, level);
		}
	}
	
	public static DataLevel getByValue(int value) {
		DataLevel level = cache.get(value);
		
		return level;
	}
}
