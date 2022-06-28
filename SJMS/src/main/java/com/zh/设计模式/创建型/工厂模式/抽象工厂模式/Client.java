package com.zh.设计模式.创建型.工厂模式.抽象工厂模式;

import com.zh.设计模式.创建型.工厂模式.抽象工厂模式.公司.GProductA;

/**
 * @author zh
 * @date 2022/6/26 23:24
 * @description:说明
 */
public class Client {
    public static void main(String[] args) {

        //客户想得到阿里公司的支付宝对象
        GProductA gProductA = new GProductA();
        gProductA.show();
    }
}
