package com.xu.algorithm.structure.hash;

/**
 * @author CharleyXu Created on 2018/9/27.
 */
public interface MyHashMap<K,V> {
    void put(K k, V v);
    V get(K k);

    interface Entry<K,V>{
        K getKey();
        V getValue();
    }

}
