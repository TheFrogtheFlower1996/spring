package com.zh.设计模式.创建型.单例模式;

/**
 * @author zh
 * @date 2022/6/23 22:01
 * @description:说明 饿汉模式 （静态代码块）
 */
public class Test02 {
    public static void main(String[] args) {

        A1 instance = A1.getInstance();

    }
}

class A1{

    //构造器私有化 外部不能 new
    private A1(){}

    //创建实例
    private static A1 a1;

    //在静态代码块中 创建实例对象
    static {
        a1 = new A1();
    }

    public static A1 getInstance(){
        return a1;
    }
}