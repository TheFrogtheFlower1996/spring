package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.例一;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author zh
 * @date 2022/6/26 16:21
 * @description:说明
 */
public class Client {
    public static void main(String[] args) {

        //需求：获取拼多多对象 拼多多是腾讯工厂的

        TxFactory txFactory = new TxFactory();
        ProductSC pdd = txFactory.getProductSC();
        String s = pdd.getProductName();
        System.out.println(s);

        ArrayList<Object> list = new ArrayList<>();
        Iterator<Object> iterator = list.iterator();
    }
}
