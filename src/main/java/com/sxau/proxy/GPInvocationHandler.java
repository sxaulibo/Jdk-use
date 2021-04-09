package com.sxau.proxy;

import java.lang.reflect.Method;

/**
 * 调用处理器
 */
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
