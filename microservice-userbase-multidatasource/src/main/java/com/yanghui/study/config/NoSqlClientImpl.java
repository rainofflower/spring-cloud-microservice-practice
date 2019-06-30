package com.yanghui.study.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程不安全的 map
 * @param <K>
 * @param <V>
 */
public class NoSqlClientImpl<K,V> implements NoSqlClient<K,V>{

    private Map<K,V> map = new HashMap<>();

    public V get(K k) {
        return map.get(k);
    }

    public V set(K k, V v){
        return map.put(k,v);
    }
}
