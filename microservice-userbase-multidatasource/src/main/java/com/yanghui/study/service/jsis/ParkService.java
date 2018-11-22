package com.yanghui.study.service.jsis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanghui.study.entity.Park;
import com.yanghui.study.mapper.jsis.ParkMapper;

@Service
public class ParkService {

	@Autowired
	private ParkMapper parkMapper;
	
	public Park getParkById(Long id) {
		return parkMapper.selectByPrimaryKey(id);
	}
}
