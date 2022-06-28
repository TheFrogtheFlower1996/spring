package com.zh.jvmtest;

/**
 * @author zh
 * @date 2022/6/17 15:53
 * @description:说明
 */
public class So extends Fu{

    // 静态常量 准备阶段 赋值
    public static final String URL = "子类 静态常量";

    //变量 初始化赋值
    public String URL3 = "子类 变量";

    //静态代码块 准备阶段赋值
    static {
        System.out.println(URL);
        System.out.println("子类 静态代码块");
    }

    //普通代码块 初始化赋值
    {
        System.out.println(URL3);
        System.out.println("子类 普通代码块");
    }

    //构造器 初始化赋值
    public So(){
        System.out.println("子类 构造器");
    }

    public static void main(String[] args) {
        new So();
    }
}
