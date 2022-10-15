package com.zh.设计模式.行为型.观察者模式;
/**
 * 具体观察者
 * */
public class WeiUser implements Observer{

    private String name;

    public WeiUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + " 具体观察者，接收到主题的更新消息： " + msg);
    }
}
