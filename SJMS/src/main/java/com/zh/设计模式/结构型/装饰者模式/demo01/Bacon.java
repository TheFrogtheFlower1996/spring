package com.zh.设计模式.结构型.装饰者模式.demo01;

/**
 * 具体装饰者角色
 * */
public class Bacon extends Garnish{

    public Bacon(FastFood fastFood){
        super(1,"培根",fastFood);
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
