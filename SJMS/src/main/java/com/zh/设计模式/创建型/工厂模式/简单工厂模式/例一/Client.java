package com.zh.设计模式.创建型.工厂模式.简单工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/24 22:00
 * @description:说明
 */
public class Client {
    public static void main(String[] args) throws Exception {


        InterfaceFather factory = SimpleFactory.getFactory("+");
        double result = factory.getResult(1, 2);
        System.out.println(result);
    }
}
