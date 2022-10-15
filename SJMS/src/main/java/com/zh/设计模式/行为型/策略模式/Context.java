package com.zh.设计模式.行为型.策略模式;

/**
 * 环境类
 * */
public class Context {

    //定义策略类参数
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    //展示促销活动
    public void show(){
        strategy.show();
    }
}
