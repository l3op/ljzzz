package com.yy.game.ljzzz.dao.jvm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.yy.game.ljzzz.dao.JvmCache;
import com.yy.game.ljzzz.exceptions.AssertHelper;

@Component
public class JvmCacheFacade<K, V> implements JvmCache<K, V> {
	protected Map<K, V> cache = new HashMap<K, V>();

	/**
	 * 过期时间, 单位为秒
	 */
	private int timeout;
	
	/**
	 * 上次更新数据时间
	 */
	protected long lastModify = 0;

	@Override
	public void setTimeout(int seconds) {
		this.timeout = seconds;
	}

	@Override
	public V getInstance(K key) {
		// 也可以弄个线程来判断
		AssertHelper.isTrue(System.currentTimeMillis() - lastModify < timeout * 1000, "数据已经过期");
		return cache.get(key);
	}

	@Override
	public void updateCache(Map<K, V> data) {
		cache = new HashMap<K, V>(data);
		lastModify = System.currentTimeMillis();
	}

	@Override
	public void flush() {
		cache = new HashMap<K, V>();
	}
	
}
