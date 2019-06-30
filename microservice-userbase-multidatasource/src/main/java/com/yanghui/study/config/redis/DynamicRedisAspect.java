package com.yanghui.study.config.redis;

import com.yanghui.study.config.database.DynamicDataSourceContextHolder;
import com.yanghui.study.config.database.TargetDataSource;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DynamicRedisAspect implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Before("@annotation(targetRedis)")
	public void before(TargetRedis targetRedis) {
		String name = targetRedis.value();
		applicationContext.getBean("redisTemplate");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}