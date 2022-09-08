package com.zh.设计模式.创建型.建造者模式.demo01;
/**抽象建造者**/
public abstract class Builder {

    //声明Bike类型的变量，并进行赋值
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    //构建自行车方法
    public abstract Bike createBike();

    //将指挥者类的 组装自行车方法 结合到抽象建造者
    public Bike construct(){
        buildFrame();
        buildSeat();
        return createBike();
    }
}
