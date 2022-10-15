package com.zh.设计模式.行为型.观察者模式.警察抓小偷;

import java.util.Observable;
import java.util.Observer;
/**
 * 观察者
 * */
public class Policemen implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("警察收到警报，抓捕小偷！！！");
    }
}
