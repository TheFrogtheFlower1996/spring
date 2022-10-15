package com.zh.设计模式.结构型.装饰者模式.demo01;

public class noodle extends FastFood{

    //无参构造设置参数
    public noodle(){
        super(15,"面条");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
