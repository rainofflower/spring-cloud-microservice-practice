package com.yanghui.study.config.redis;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicRedisTemplate implements ApplicationRunner {

    private final Map<String, RedisTemplate> redisTemplates = new ConcurrentHashMap<>();

    private int maxIdle = 10;

    private int minIdle = 1;

    public void run(ApplicationArguments args) throws Exception {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
    }
}
