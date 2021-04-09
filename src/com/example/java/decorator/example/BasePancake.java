package com.example.java.decorator.example;

/**
 * 煎饼基础套餐
 */
public class BasePancake extends Pancake{
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
