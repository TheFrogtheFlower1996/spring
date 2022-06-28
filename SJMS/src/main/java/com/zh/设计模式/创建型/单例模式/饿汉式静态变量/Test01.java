package com.zh.设计模式.创建型.单例模式;

/**
 * @author zh
 * @date 2022/6/23 21:43
 * @description:说明 饿汉式（静态常量）
 */
public class Test01 {
    public static void main(String[] args) {

        A instance1 = A.getInstance();
        A instance2 = A.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }


}

class A{

    //构造器私有化，确保不能通过 new 实例化对象
    private A(){}

    //在类加载时 创建对象实例
    private static final A a = new A();

    //提供公有静态方法，返回实例化对象
    public static A getInstance(){
        return a;
    }
}
