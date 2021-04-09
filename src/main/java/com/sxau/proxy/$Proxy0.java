package com.sxau.proxy;

import com.sxau.proxy.iProxy.IPerson;

import java.lang.reflect.*;

/**
 * 这个是代理生成的中间类
 */
public class $Proxy0 implements IPerson {
    GPInvocationHandler h;

    public $Proxy0(GPInvocationHandler h) {
        this.h = h;
    }

    public void findLove() {
        try {
            Method m = IPerson.class.getMethod("findLove", new Class[]{});
            this.h.invoke(this, m, new Object[]{});
        } catch (Error _ex) {
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}

