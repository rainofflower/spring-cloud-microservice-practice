package com.yanghui.study.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yanghui.study.cloud.entity.User;
import com.yanghui.study.cloud.feign.UserFeignClient;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("movie/{id}")
	public User getById(@PathVariable Long id) {
		return this.userFeignClient.getUser(id);
	}
	
	@GetMapping("movie/list-user")
	public List<User> listUser(){
		return this.userFeignClient.listUser();
	}
}
