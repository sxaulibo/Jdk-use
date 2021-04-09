package com.example.java.facade;

import jdk.internal.platform.cgroupv1.SubSystem;

/**
 * facade pattern 门面模式通用写法
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }

    //外观角色
    static class Facade {
        private SubSystemA a = new SubSystemA();
        private SubSystemB b = new SubSystemB();
        private SubSystemC c = new SubSystemC();

        //对外接口
        public void doA() {
            this.a.doA();
        }

        //对外接口
        public void doB() {
            this.b.doB();
        }

        //对外接口
        public void doC() {
            this.c.doC();
        }
    }

    //子系统A
    private static class SubSystemA {
        public void doA() {
            System.out.println("doing A stuff");
        }
    }

    //子系统B
    private static class SubSystemB {
        public void doB() {
            System.out.println("doing B stuff");
        }
    }

    //子系统C
    private static class SubSystemC {
        public void doC() {
            System.out.println("doing C stuff");
        }
    }
}
