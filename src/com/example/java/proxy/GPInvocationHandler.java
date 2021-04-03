package com.example.java.proxy;

import java.lang.reflect.Method;

public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
