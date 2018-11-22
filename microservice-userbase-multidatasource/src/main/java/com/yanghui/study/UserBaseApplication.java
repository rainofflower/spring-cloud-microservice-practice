package com.yanghui.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableEurekaClient
public class UserBaseApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserBaseApplication.class, args);
	}
}
