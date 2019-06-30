package com.yanghui.study.service;

import com.yanghui.study.config.database.DynamicDataSourceContextHolder;
import com.yanghui.study.config.database.TargetDataSource;
import com.yanghui.study.entity.Message;
import com.yanghui.study.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanghui.study.entity.User;
import com.yanghui.study.mapper.UserMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MessageMapper messageMapper;

	@TargetDataSource("test")
	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public Map getUserMessage(Long id) {
		Example example = new Example(Message.class);
		example.createCriteria().andEqualTo("senderId",id);
		DynamicDataSourceContextHolder.set("im");
		messageMapper.selectByExample(example);
		DynamicDataSourceContextHolder.set("test");
		User user = userMapper.selectByPrimaryKey(id);
		DynamicDataSourceContextHolder.set("im");
		List<Message> messages = messageMapper.selectByExample(example);
		Map<String, Object> map = new HashMap<>();
		map.put("sender", user);
		map.put("messages",messages);
		//不切换数据源后面将报错
//		DynamicDataSourceContextHolder.set("test");
		userMapper.selectByPrimaryKey(id);
		return map;
	}

	@TargetDataSource("im")
	public List<Message> getMessage(Long id) {
		Example example = new Example(Message.class);
		example.createCriteria().andEqualTo("senderId",id);
		return messageMapper.selectByExample(example);
	}
}
