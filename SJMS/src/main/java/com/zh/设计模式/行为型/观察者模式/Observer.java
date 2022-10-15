package com.zh.设计模式.行为型.观察者模式;

/**
 * 抽象观察者
 * */
public interface Observer {

    //提供一个更新方法，用于主题改变时通知自己
    void update(String msg);
}
