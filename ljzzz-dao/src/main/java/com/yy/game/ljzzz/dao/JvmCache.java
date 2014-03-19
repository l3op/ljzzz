package com.yy.game.ljzzz.dao;

import java.util.Map;

/**
 * jvm缓存实现
 */
public interface JvmCache<K, V> {
	/**
	 * 读取缓存中数据
	 * @param key
	 * @return
	 */
	V getInstance(K key);
	
	/**
	 * 更新缓存中数据
	 */
	void updateCache(Map<K, V> data);
	
	/**
	 * 设置数据最大有效时间
	 * @param seconds
	 */
	void setTimeout(int seconds);
	
	/**
	 * 清空缓存
	 */
	void flush();
}
