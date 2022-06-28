package com.zh.设计模式.创建型.工厂模式.简单工厂模式.简单工厂;

/**
 * @author zh
 * @date 2022/6/26 22:24
 * @description:说明 客户端
 */
public class Client {
    public static void main(String[] args) {

        Factory.getInstance("A").show();

    }
}
