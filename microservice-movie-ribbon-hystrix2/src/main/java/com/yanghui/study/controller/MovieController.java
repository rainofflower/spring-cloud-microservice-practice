package com.yanghui.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yanghui.study.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod = "fallbackFunc")
	public User getUserInfo(@PathVariable Long id) {
		return restTemplate.getForObject("http://microservice-userbase/user/" + id, User.class);
	}

	public User fallbackFunc(Long id) {
		User user = new User();
		user.setName("默认人员");
		user.setAge(0);
		return user;
	}
}
