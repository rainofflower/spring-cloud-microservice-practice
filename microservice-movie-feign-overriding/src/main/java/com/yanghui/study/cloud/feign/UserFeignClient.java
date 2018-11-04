package com.yanghui.study.cloud.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yanghui.study.cloud.entity.User;
import com.yanghui.study.config.FooConfiguration;

@FeignClient(name = "${service.name.user-base-service}", configuration = FooConfiguration.class)
public interface UserFeignClient {

	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
	public User getUser(@PathVariable("id") Long id);
	
	@RequestMapping(value="/user/list",method = RequestMethod.GET)
	public List<User> listUser();
}
