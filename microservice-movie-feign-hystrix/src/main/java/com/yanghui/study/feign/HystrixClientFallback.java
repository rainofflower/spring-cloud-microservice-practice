package com.yanghui.study.feign;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yanghui.study.entity.User;

@Component
public class HystrixClientFallback implements UserFeignClient{

	@Override
	public User getUser(Long id) {
		User user = new User();
		user.setId(0L);
		user.setName("默认人员");
		user.setAge(0);
		return user;
	}

	@Override
	public List<User> listUser() {
		List<User> list = new ArrayList<>();
		User user = new User();
		user.setName("默认人员1");
		user.setAge(0);
		list.add(user);
		user.setName("默认人员2");
		list.add(user);
		return list;
	}

	
}
