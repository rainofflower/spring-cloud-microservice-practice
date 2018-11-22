package com.yanghui.study.service.localhost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanghui.study.entity.User;
import com.yanghui.study.mapper.localhost.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}
}
