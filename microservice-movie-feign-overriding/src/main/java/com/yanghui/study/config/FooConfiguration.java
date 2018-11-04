package com.yanghui.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FooConfiguration {

	@Bean
	public Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
	
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("user", "password");
	}
	
}
