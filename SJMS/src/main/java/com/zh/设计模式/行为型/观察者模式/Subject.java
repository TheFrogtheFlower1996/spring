package com.zh.设计模式.行为型.观察者模式;
/**
 * 抽象主题（被观察者）
 * */
public interface Subject {

    // 添加订阅者（添加观察者对象）
    void attach(Observer observer);

    // 删除订阅者
    void detach(Observer observer);

    // 通知订阅者更新
    void notify(String msg);
}
