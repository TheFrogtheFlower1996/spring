package com.zh.设计模式.结构型.代理模式.JDK动态代理;

import com.zh.设计模式.结构型.代理模式.静态代理.SellTickets;
import com.zh.设计模式.结构型.代理模式.静态代理.TrainStation;

public class Client {
    public static void main(String[] args) {

        //获取代理工厂
        ProxyFactory factory = new ProxyFactory(new TrainStation());
        //获取代理类
        SellTickets proxyObject = (SellTickets)factory.getProxyObject();
        //执行代理方法
        proxyObject.sell();
    }
}
