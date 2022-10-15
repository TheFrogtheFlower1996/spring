package com.zh.设计模式.创建型.建造者模式.demo01;
/**
 * 指挥者类
 * **/
public class Director {

    //声明builder类型变量
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    //组装自行车的方法
    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }

}
