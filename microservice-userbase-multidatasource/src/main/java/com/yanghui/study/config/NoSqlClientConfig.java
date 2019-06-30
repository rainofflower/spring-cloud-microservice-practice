package com.yanghui.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoSqlClientConfig {

    @Bean
    public NoSqlClient noSqlClient(){
        return new ProxyUtil<NoSqlClient>(new NoSqlClientImpl<String,String>()).getProxyInstance();
    }
}
