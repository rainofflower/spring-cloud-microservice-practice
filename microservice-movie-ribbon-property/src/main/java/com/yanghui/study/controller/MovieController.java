package com.yanghui.study.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yanghui.study.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@GetMapping("/movie/{id}")
	public User getById(@PathVariable Long id) {
		return restTemplate.getForObject("http://microservice-userbase/user/" + id, User.class);
	}

	@GetMapping("/test")
	public void doStuff() {
		ServiceInstance instance = loadBalancer.choose("microservice-userbase");
		URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
		System.out.println(storesUri);
	}
}
