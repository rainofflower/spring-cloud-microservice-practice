package com.yanghui.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanghui.study.entity.Park;
import com.yanghui.study.service.ParkService;

@RestController
public class ParkController {
	
	@Value("${server.port}")
	private Integer currentPort;

	@Autowired
	private ParkService parkService;
	
	@RequestMapping("/park/{id}")
	public Park getParkById(@PathVariable Long id) {
		System.out.println("请求命中服务------port:"+this.currentPort);		//配置不同端口启动，测试命中具体服务
		return parkService.getParkById(id);
	}
}
