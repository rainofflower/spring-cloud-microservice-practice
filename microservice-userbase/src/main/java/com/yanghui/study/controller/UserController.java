package com.yanghui.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanghui.study.entity.User;
import com.yanghui.study.mapper.UserMapper;

@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		System.out.println("请求命中服务------");
		return userMapper.selectByPrimaryKey(id);
	}
}
