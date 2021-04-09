package com.example.java.decorator.example;

/**
 * 鸡蛋装饰器
 */
public class EggDecorator extends PancakeDecorator {

    public EggDecorator(Pancake pancake) {
        super(pancake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
