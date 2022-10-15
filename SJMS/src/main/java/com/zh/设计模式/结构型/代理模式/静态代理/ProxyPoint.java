package com.zh.设计模式.结构型.代理模式.静态代理;

/**
 * 代理类
 * **/
public class ProxyPoint implements SellTickets{

    //定义目标类型，用于代理
    private TrainStation proxyPoint;

    public ProxyPoint(TrainStation proxyPoint) {
        this.proxyPoint = proxyPoint;
    }

    @Override
    public void sell() {
        System.out.println("代理收费！！！");
        proxyPoint.sell();
    }
}
