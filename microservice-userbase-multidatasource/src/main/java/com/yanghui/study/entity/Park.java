package com.yanghui.study.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="park")
@Getter
@Setter
public class Park {
	
	@Id
	@GeneratedValue(generator = "JDBC")
    private Long id;

    private String name;
}