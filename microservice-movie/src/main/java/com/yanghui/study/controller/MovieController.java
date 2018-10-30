package com.yanghui.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yanghui.study.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${user-service-path}")
	private String url;
	
	@GetMapping("/movie/{id}")
	public User getById(@PathVariable Long id) {
		return restTemplate.getForObject(this.url + id, User.class);
	}
}
