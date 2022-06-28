package com.zh.设计模式.创建型.单例模式.懒汉式线程不安全;

/**
 * @author zh
 * @date 2022/6/23 22:14
 * @description:说明 懒汉式 线程不安全
 */
public class Test01 {
    public static void main(String[] args) {

        A instance = A.getInstance();
        System.out.println(instance);
    }
}

class A {

    //构造器 私有化
    private A(){}

    //实例化A
    private static A a;

    //提供公有静态方法
    public static A getInstance(){
        if (a == null){
            a = new A();
        }
        return a;
    }
}
