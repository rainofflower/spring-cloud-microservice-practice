package com.yanghui.study.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yanghui.study.entity.User;

@FeignClient(name = "${service.name.user-base-service}", fallback = HystrixClientFallback.class)
public interface UserFeignClient {

	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
	public User getUser(@PathVariable("id") Long id);
	
	@RequestMapping(value="/user/list",method = RequestMethod.GET)
	public List<User> listUser();

	@RequestMapping(value="/user/test-timeout",method = RequestMethod.GET)
	public String testTimeOut();
}
