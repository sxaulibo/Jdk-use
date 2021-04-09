package com.example.java.proxy;

import com.example.java.proxy.iProxy.IPerson;

import java.lang.reflect.*;

/**
 * 这个是代理生成的中间类
 */
public class $Proxy0 implements com.example.java.proxy.iProxy.IPerson {
    GPInvocationHandler h;

    public $Proxy0(GPInvocationHandler h) {
        this.h = h;
    }

    public void findLove() {
        try {
            Method m = com.example.java.proxy.iProxy.IPerson.class.getMethod("findLove", new Class[]{});
            this.h.invoke(this, m, new Object[]{});
        } catch (Error _ex) {
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}

