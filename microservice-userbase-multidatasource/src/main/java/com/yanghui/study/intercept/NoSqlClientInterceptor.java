package com.yanghui.study.intercept;

import com.yanghui.study.config.Factory;
import com.yanghui.study.config.NoSqlClientImpl;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicInteger;

public class NoSqlClientInterceptor extends HandlerInterceptorAdapter {

    private AtomicInteger requestNum = new AtomicInteger();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        NoSqlClientImpl<String, String> noSqlClient = new NoSqlClientImpl<>();
        noSqlClient.set("user", "user"+requestNum.incrementAndGet());
        Factory.set(noSqlClient);
        return true;
    }
}
