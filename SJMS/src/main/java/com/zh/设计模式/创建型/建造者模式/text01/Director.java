package com.zh.设计模式.创建型.建造者模式.text01;

/** （抽象） 指挥者类 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /** 构造产品方法 */
    public Computer construct(){
        builder.setCPU();
        builder.setGraphicsCard();
        builder.setMemory();
        Computer computer = builder.createComputer();
        return computer;
    }
}
