package com.zh.设计模式.行为型.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题
 * */
public class ConcreteSubject implements Subject{

    //存储观察者对象
    private List<Observer> weiXinUserLists = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weiXinUserLists.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weiXinUserLists.remove(observer);
    }

    //通知观察者方法
    @Override
    public void notify(String msg) {
        //遍历集合
        for (Observer user : weiXinUserLists) {
            user.update(msg);
        }
    }
}
