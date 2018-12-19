package com.yanghui.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayCustomFilterApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayCustomFilterApplication.class, args);
	}
}
