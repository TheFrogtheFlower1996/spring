package com.zh.设计模式.创建型.工厂模式.工厂方法模式.例一;

/**
 * @author zh
 * @date 2022/6/25 18:10
 * @description:说明 抽象类
 */
public abstract class Coffee {

    //抽象方法 getName()，用于子类重写
    public abstract String getName();

    public void add(){
        System.out.println("咖啡加糖");
    }
}
