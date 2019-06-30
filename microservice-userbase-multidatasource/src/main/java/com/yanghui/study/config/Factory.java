package com.yanghui.study.config;

public class Factory {

    private static final ThreadLocal<NoSqlClient> CURRENT = new ThreadLocal<>();

    public static NoSqlClient get(){
        return CURRENT.get();
    }

    public static void set(NoSqlClient v){
        CURRENT.set(v);
    }
}
