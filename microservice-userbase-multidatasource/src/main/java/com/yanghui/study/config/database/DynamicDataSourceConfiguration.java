package com.yanghui.study.config.database;

import com.alibaba.druid.pool.DruidDataSource;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@MapperScan("com.yanghui.study.mapper")
@Configuration
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
@Slf4j
public class DynamicDataSourceConfiguration {

    @Autowired
    private DynamicDataSourceProperties properties;

    /**
     * 动态数据源
     */
    @Bean
    @ConditionalOnMissingBean
    public DataSource dataSource() {
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        Map<String, DataSourceProperties> dataSourcePropertiesMap = properties.getDatasource();
        Map<Object, Object> dataSourceMap = new HashMap<>(dataSourcePropertiesMap.size());
        for(String name: dataSourcePropertiesMap.keySet()){
            DataSourceProperties dataSourceProperties = dataSourcePropertiesMap.get(name);
            DruidDataSource source = new DruidDataSource();
            source.setUsername(dataSourceProperties.getUsername());
            source.setPassword(dataSourceProperties.getPassword());
            source.setUrl(dataSourceProperties.getUrl());
            source.setDriverClassName(dataSourceProperties.getDriverClassName());
            source.setName(name);
            try {
                source.init();
            } catch (SQLException e) {
                log.info("数据源初始化失败，信息："+e);
                break;
            }
            dataSourceMap.put(name, source);
        }
        log.info("共加载{}个数据源",dataSourceMap.size());
        dataSource.setDefaultTargetDataSource(dataSourceMap.get(properties.getDefaultDataSource()));
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    /**
     * 事务管理
     * @return 事务管理实例
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}