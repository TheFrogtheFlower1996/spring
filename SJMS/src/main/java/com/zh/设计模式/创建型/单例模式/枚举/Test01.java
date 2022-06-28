package com.zh.设计模式.创建型.单例模式.枚举;

/**
 * @author zh
 * @date 2022/6/24 11:36
 * @description:说明 枚举
 */
public class Test01 {
    public static void main(String[] args) {
        A instance = A.INSTANCE;
        A instance1 = A.INSTANCE;
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());

//        Runtime

    }
}

enum A{ //枚举类
    INSTANCE;//属性
    public void say(){
        System.out.println("hello");
    }
}
