package com.zh.设计模式.结构型.代理模式.cglib动态代理;

public class Client {
    public static void main(String[] args) {

        //目标对象
        TrainStation trainStation = new TrainStation();
        //代理工厂对象
        ProxyFactory proxyFactory = new ProxyFactory(trainStation);
        //代理对象
        TrainStation proxyObject = (TrainStation) proxyFactory.getProxyObject();
        //代理对象代理方法
        proxyObject.sell();
    }
}
