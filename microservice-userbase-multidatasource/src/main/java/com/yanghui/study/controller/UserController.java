package com.yanghui.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanghui.study.entity.User;
import com.yanghui.study.service.localhost.UserService;

@RestController
public class UserController {
	
	@Value("${server.port}")
	private Integer currentPort;

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		System.out.println("请求命中服务------port:"+this.currentPort);		//配置不同端口启动，测试命中具体服务
		return userService.getUserById(id);
	}
}
