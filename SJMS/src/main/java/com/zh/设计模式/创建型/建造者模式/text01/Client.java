package com.zh.设计模式.创建型.建造者模式.text01;

/** (具体)客户端 */
public class Client {
    public static void main(String[] args) {
        /** 传入具体建造者，得到指挥者 */
        Director director = new Director(new Dell());
        /** 指挥者构建具体产品 */
        Computer computer = director.construct();

        System.out.println(computer);
    }
}
