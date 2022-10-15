package com.zh.设计模式.行为型.观察者模式.警察抓小偷;

import lombok.Data;

import java.util.Observable;
/**
 * 具体主题，被观察者（小偷类）
 * */
@Data
public class Thief extends Observable {

    private String name;

    //广播方法
    public void steal(){
        System.out.println("小偷偷东西了，触发警报，通知警察！！！");
        super.setChanged();// changed = true
        super.notifyObservers();//通知警察
    }
}
