package com.sxau.decorator.example;

/**
 * 李小博买煎饼
 */
public class PancakeTest {
    public static void main(String[] args) {
        Pancake pancake;
        //买一个煎饼
        pancake = new BasePancake();
        //煎饼有点小，想再加一个鸡蛋
        pancake = new EggDecorator(pancake);
        //再加一个鸡蛋
        pancake = new EggDecorator(pancake);
        //很饿，再加一个香肠
        pancake = new SausageDecorator(pancake);

        //与静态代理的最大不同区别就是职责不同
        //静态代理不一定要满足is-a的关系
        //静态代理会做功能增强，同一个职责变得不一样

        //装饰器更多考虑的是扩展
        System.out.println(pancake.getMsg() + "，总价" + pancake.getPrice());

    }
}
