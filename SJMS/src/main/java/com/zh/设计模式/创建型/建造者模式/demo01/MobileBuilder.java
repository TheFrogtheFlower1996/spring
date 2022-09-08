package com.zh.设计模式.创建型.建造者模式.demo01;

/**
 * 具体建造者：摩拜单车
 * */
public class MobileBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setFrame("摩拜单车 用 碳纤维车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("摩拜单车 用 真皮车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
