package com.yanghui.study.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DynamicDataSourceAspect {


	@Before("@annotation(targetDataSource)")
	public void before(TargetDataSource targetDataSource) {
		String name = targetDataSource.value();
		DynamicDataSourceContextHolder.set(name);
	}

	@After("@annotation(TargetDataSource)")
	public void after(){
		DynamicDataSourceContextHolder.clear();
	}
}