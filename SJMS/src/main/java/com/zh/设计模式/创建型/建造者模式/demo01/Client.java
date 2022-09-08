package com.zh.设计模式.创建型.建造者模式.demo01;

//客户端
public class Client {
    public static void main(String[] args) {

        Director director = new Director(new MobileBuilder());//创建指挥者对象
        Bike bike = director.construct();//指挥者调用组装方法，得到具体产品
        System.out.println(bike);
    }
}
