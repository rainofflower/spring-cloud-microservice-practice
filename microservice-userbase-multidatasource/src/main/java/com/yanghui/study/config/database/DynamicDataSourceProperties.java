package com.yanghui.study.config.database;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "spring")
@Getter
@Setter
public class DynamicDataSourceProperties {

    private String defaultDataSource = "test";

    private Map<String, DataSourceProperties> datasource = new LinkedHashMap<>();
}
