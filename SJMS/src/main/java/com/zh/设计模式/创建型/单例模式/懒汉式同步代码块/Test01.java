package com.zh.设计模式.创建型.单例模式.懒汉式同步代码块;

/**
 * @author zh
 * @date 2022/6/23 22:27
 * @description:说明 懒汉式 同步代码块
 */
public class Test01 {
    public static void main(String[] args) {

    }
}

class A {

    //构造器私有化
    private A(){}

    //实例化
    private static A a;


}
