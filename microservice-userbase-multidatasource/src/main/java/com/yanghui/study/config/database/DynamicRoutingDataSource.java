package com.yanghui.study.config.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.get();
    }
}