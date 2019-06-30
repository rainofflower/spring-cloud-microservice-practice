package com.yanghui.study.config;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyUtil<T> implements MethodInterceptor {

    private T obj;

    public ProxyUtil(T obj){
        this.obj = obj;
    }

    public T getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return (T)enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("get")){
            return Factory.get().get(args[0]);
        }
        else if(method.getName().equals("set")){
            return Factory.get().set(args[0],args[1]);
        }
        return method.invoke(o, args);
    }

    public String toString(){
        return "current client";
    }
}
