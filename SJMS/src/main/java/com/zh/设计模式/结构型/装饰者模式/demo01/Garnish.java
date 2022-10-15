package com.zh.设计模式.结构型.装饰者模式.demo01;

/**
 * 抽象装饰者
 * 继承、聚合了 抽象构件角色
 * */
public abstract class Garnish extends FastFood{

    //声明快餐类类型的变量
    private FastFood fastFood;

    //全参
    public Garnish(float price, String desc, FastFood fastFood) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
