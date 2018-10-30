package com.yanghui.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yanghui.study.mapper")
public class UserBaseApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserBaseApplication.class, args);
	}
}
