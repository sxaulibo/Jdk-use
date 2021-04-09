package com.example.java.proxy.iProxy;

import com.example.java.proxy.GPClassLoader;
import com.example.java.proxy.GPInvocationHandler;
import com.example.java.proxy.GPProxy;

import java.lang.reflect.Method;

/**
 * 媒婆
 */
public class GPMatchMaker implements GPInvocationHandler {

    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;
        Class<?> clazz = target.getClass();

        /**
         * Java的动态代理比代理的思想更向前迈进一步，因为它可以动态地创建代理并动态地处理对所代理方法的调用
         * 在动态代理上多做的所有调用都会被重定向到单一的调用处理器上，它的工作是揭示调用的类型并确定相应的对策。
         *
         * 通过调用静态方法GPProxy.newProxyInstance可以创建动态代理。
         * 这个方法需要得到一个类加载器(你通常可以从已经被加载的对象中获取其类加载器，然后传递给它)
         * 一个你希望该代理实现的接口列表(不是类或者抽象类)
         * 以及InvocationHandler接口的一个实现。
         *
         * 动态代理可以将所有调用重定向到调用处理器(媒婆)，
         * 因此通常会向调用处理器的构造器传递一个"实际"对象的引用。从而使得调用处理器在执行其中介任务时，可以将请求转发。
         * this.target = target;
         */
        return (IPerson) GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("双方同意，开始交往");
    }

    private void before() {
        System.out.println("我是媒婆，已经收集到你的需求，开始物色");
    }
}
