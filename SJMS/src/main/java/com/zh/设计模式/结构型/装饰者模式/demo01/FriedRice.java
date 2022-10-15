package com.zh.设计模式.结构型.装饰者模式.demo01;

/**
 * 具体构件角色
 * 炒饭类
 * */
public class FriedRice extends FastFood{

    //定义无参构造，设置参数
    public FriedRice(){
        super(10,"炒饭一份");
    }

    //从父类中获取价格
    @Override
    public float cost() {
        return getPrice();
    }
}
