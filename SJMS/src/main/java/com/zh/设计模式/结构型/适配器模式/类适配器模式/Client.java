package com.zh.设计模式.结构型.适配器模式.类适配器模式;

public class Client {
    public static void main(String[] args) {

        Computer computer = new Computer();
        //读取cd卡中数据
        String MSG = computer.readCD(new CDCardImpl());
        System.out.println("msg: " + MSG);

        //电脑读取TF卡

        String mag2 = computer.readCD(new CDAdapterTF());
        System.out.println("TFcard msg: " + mag2);

        //写入TF卡

    }
}
