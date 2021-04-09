package com.example.java.proxy;


public class Client {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();
    }

    //抽象主题角色
    interface ISubject {
        void request();
    }


    //代理主题角色
    static class Proxy implements ISubject {
        private ISubject subject;

        public Proxy(ISubject subject) {
            this.subject = subject;
        }


        public void before() {
            System.out.println("called before request().");
        }

        public void after() {
            System.out.println("called after request().");
        }

        public void request() {
            before();
            subject.request();
            after();
        }
    }

    //真实主题角色
    static class RealSubject implements ISubject {
        @Override
        public void request() {
            System.out.println("real service is called.");
        }
    }
}
