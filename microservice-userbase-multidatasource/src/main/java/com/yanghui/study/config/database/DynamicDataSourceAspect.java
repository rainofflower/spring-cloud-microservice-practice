package com.yanghui.study.config.database;

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

	@After("@annotation(com.yanghui.study.config.database.TargetDataSource)")
	public void after(){
		DynamicDataSourceContextHolder.clear();
	}
}