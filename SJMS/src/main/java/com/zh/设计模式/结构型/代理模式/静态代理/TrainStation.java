package com.zh.设计模式.结构型.代理模式.静态代理;
/**
 * 火车站类（目标对象）
 * **/
public class TrainStation implements SellTickets{
    @Override
    public void sell() {
        System.out.println("火车站卖票！！");
    }
}
