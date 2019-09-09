
package com.hao.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * 纯手写单个JVM 缓存框架
 * @author hao
 *
 * @param <K>
 * @param <V>
 */
@Component
public class MapCaChe<K, V> {
	private Map<K, V> ehcaCheMap = new ConcurrentHashMap<K, V>();

	public void put(K k, V value) {
		ehcaCheMap.put(k, value);
	}

	public V get(K k) {
		return ehcaCheMap.get(k);
	}

	public void remove(K k) {
		ehcaCheMap.remove(k);
	}
}
