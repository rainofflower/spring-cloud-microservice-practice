package com.yanghui.study.config.web;

import com.yanghui.study.intercept.NoSqlClientInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(noSqlClientInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public NoSqlClientInterceptor noSqlClientInterceptor(){
        return new NoSqlClientInterceptor();
    }
}
