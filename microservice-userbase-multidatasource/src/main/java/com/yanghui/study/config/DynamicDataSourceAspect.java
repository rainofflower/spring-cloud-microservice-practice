package com.yanghui.study.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {

	/**
	 * 定义localhost数据源切点表达式
	 * execution(public int com.yanghui.aop.MathCalculator.*(..))
	 * com.yanghui.study.service.jsis
	 */
	@Pointcut("execution(* com.yanghui.study.service.localhost..*(..))")
	public void localhostJointPoint() {
	}

	/**
	 * 设置localhost数据源
	 */
	@Before("localhostJointPoint()")
	public void setLocalhostJointPointDataSource(JoinPoint point) {
		DynamicDataSourceContextHolder.set(DataSourceKey.LOCALHOST);
	}

	/**
	 * 定义jsis数据源切点表达式
	 */
	@Pointcut("execution(* com.yanghui.study.service.jsis..*(..))")
	public void jsisJointPoint() {
	}

	/**
	 * 设置jsis数据源
	 */
	@Before("jsisJointPoint()")
	public void setJsisDataSource(JoinPoint point) {
		DynamicDataSourceContextHolder.set(DataSourceKey.JSIS);
	}

}