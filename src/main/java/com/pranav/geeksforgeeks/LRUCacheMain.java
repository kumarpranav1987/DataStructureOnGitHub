package com.pranav.geeksforgeeks;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
	private Map<Integer, Integer> cache;
	private int maxSize;

	public LRUCache(int N) {
		maxSize = N;
		cache = new LinkedHashMap<>(N);
	}

	public int get(int x) {
		Integer value = cache.get(x);
		if (value != null) {
			cache.remove(x);
			cache.put(x, value);
			return value;
		} else {
			return -1;
		}
	}

	public void set(int x, int y) {
		Integer previousValue = cache.get(x);
		if (previousValue != null) {
			cache.remove(x);
			cache.put(x, y);
		} else {
			if(cache.size()==maxSize) {
				cache.remove(cache.keySet().iterator().next());
				cache.put(x, y);
			}else {
				cache.put(x, y);
			}
		}
	}
}

public class LRUCacheMain {
	public static void main(String[] args) {
		Map<Integer, Integer> cache = new LinkedHashMap<>();
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.remove(1);
		cache.put(1, 5);
		for (Integer key : cache.keySet()) {
			System.out.println("Key:" + key + " Value:" + cache.get(key));
		}
	}
}
