package com.sxau.decorator.example;

public class SausageDecorator extends PancakeDecorator {
    public SausageDecorator(Pancake pancake) {
        super(pancake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }

    @Override
    protected void doSomething() {

    }
}
