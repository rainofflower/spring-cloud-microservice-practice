package com.yanghui.study.service;

import com.yanghui.study.config.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanghui.study.entity.Park;
import com.yanghui.study.mapper.ParkMapper;

@Service
public class ParkService {

	@Autowired
	private ParkMapper parkMapper;

	@TargetDataSource("park")
	public Park getParkById(Long id) {
		return parkMapper.selectByPrimaryKey(id);
	}
}
