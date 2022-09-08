package com.zh.设计模式.创建型.建造者模式.demo01;

/**
 * 具体建造者：ofo单车
 * */
public class OfoBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setFrame("ofo单车 用 铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("ofo单车 用 橡胶车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
