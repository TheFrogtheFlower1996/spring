package com.zh.设计模式.结构型.装饰者模式.demo01;

/**
 * 具体装饰者
 * */
public class Egg extends Garnish{

    public Egg(FastFood fastFood){
        super(1,"鸡蛋",fastFood);
    }

    //计算总价
    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
