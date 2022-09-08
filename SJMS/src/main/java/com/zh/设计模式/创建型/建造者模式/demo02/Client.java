package com.zh.设计模式.创建型.建造者模式.demo02;

public class Client {
    public static void main(String[] args) {

        Phone phone = new Phone.Builder()
                .cpu("安卓")
                .screen("三星")
                .mainboard("京东方")
                .memory("金士顿")
                .build();

        System.out.println(phone);
    }
}
