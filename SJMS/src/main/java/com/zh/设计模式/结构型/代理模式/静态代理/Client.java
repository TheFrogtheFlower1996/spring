package com.zh.设计模式.结构型.代理模式.静态代理;

public class Client {
    public static void main(String[] args) {

        ProxyPoint point = new ProxyPoint(new TrainStation());
        point.sell();
    }
}
