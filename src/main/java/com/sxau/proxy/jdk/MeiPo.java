package com.sxau.proxy.jdk;

import com.sxau.proxy.iProxy.IPerson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeiPo implements InvocationHandler {

    IPerson iPerson;

    public IPerson getInstance(IPerson target) {
        this.iPerson = target;
        return (IPerson) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始调用");
        Object result = method.invoke(this.iPerson, args);
        System.out.println("代理调用完毕");
        return result;
    }
}
