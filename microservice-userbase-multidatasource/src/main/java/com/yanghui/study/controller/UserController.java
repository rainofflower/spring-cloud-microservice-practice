package com.yanghui.study.controller;

import com.yanghui.study.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanghui.study.entity.User;
import com.yanghui.study.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@RequestMapping("/userMessage/{id}")
	public Map getUserMessage(@PathVariable Long id) {
		//return userService.getUserMessage(id);
		User user = userService.getUserById(id);
		List<Message> message = userService.getMessage(id);
		Map map = new HashMap<>();
		map.put("user", user);
		map.put("message", message);
		return map;
	}

	@RequestMapping("/message/{id}")
	public List<Message> getMessage(@PathVariable Long id) {
		return userService.getMessage(id);
	}
}
