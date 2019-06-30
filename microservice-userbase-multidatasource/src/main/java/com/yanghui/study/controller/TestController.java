package com.yanghui.study.controller;

import com.yanghui.study.config.NoSqlClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private NoSqlClient client;

    @RequestMapping("get")
    public Object get(){
        return client.get("user");
    }
}
