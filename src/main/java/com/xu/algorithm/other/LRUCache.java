package com.xu.algorithm.other;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author CharleyXu Created on 2018/3/7.
 */
@Data
public class LRUCache<K, V> {

    private int MAX_CACHE_SIZE;
    private float loadingFactor = 0.75f;
    private Map<K, V> map;

    public LRUCache(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / loadingFactor) + 1;
        map = new LinkedHashMap<K, V>(capacity, loadingFactor, true) {

            @Override
            protected boolean removeEldestEntry(Entry<K, V> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
        map = new LinkedHashMap<K, V>(capacity, loadingFactor, true) {
            @Override
            protected boolean removeEldestEntry(Entry<K, V> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public V get(K k) {
        return map.get(k);
    }

    public void put(K k, V v) {
        map.put(k, v);
    }

    public int size() {
        return map.size();
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<Integer, Integer>(2);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        lruCache.put(3, 22);
        lruCache.put(4, 22);
        lruCache.put(5, 22);
        System.out.println(lruCache.get(3));
        lruCache.put(6, 33);
        System.out.println(lruCache);
    }
}
