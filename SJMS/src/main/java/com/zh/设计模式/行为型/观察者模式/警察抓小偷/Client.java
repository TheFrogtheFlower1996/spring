package com.zh.设计模式.行为型.观察者模式.警察抓小偷;

public class Client {
    public static void main(String[] args) {

        //定义主题
        Thief thief = new Thief();
        thief.setName("张麻子");

        //定义观察者
        Policemen policemen = new Policemen();

        //观察者订阅主题
        thief.addObserver(policemen);

        //小偷偷东西
        thief.steal();
    }
}
