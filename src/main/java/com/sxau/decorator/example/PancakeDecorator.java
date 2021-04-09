package com.sxau.decorator.example;

/**
 * 扩展套餐的抽象修饰器
 */
public abstract class PancakeDecorator extends Pancake {
    //静态代理，委派
    private Pancake pancake;

    public PancakeDecorator(Pancake pancake) {
        this.pancake = pancake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.pancake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.pancake.getPrice();
    }
}
