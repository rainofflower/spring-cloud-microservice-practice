package com.yanghui.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yanghui.study.entity.User;
import com.yanghui.study.feign.UserFeignClient;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/movie/{id}")
	public User getById(@PathVariable Long id) {
		return this.userFeignClient.getUser(id);
	}
	
	@GetMapping("/movie/list-user")
	public List<User> listUser(){
		return this.userFeignClient.listUser();
	}
	
	@GetMapping("/movie/test-timeout")
	public String testTimeOut() {
		return userFeignClient.testTimeOut();
	}

	@GetMapping("/movie/test")
	public String test() {
		return "哈哈";
	}
}
