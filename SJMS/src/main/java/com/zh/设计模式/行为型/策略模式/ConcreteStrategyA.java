package com.zh.设计模式.行为型.策略模式;

public class ConcreteStrategyA implements Strategy{
    @Override
    public void show() {
        System.out.println("中秋节促销开始啦！！！");
    }
}
