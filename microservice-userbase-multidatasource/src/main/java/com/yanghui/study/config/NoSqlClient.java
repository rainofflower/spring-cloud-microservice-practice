package com.yanghui.study.config;

public interface NoSqlClient<K,V> {

    V get(K k);

    V set(K k,V v);
}
