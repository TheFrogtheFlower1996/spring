package com.zh.jvmtest;

/**
 * @author zh
 * @date 2022/6/17 15:22
 * @description:说明 java对象初始化
 */
public class test01 {

    // 静态常量 准备阶段 赋值
    public static final String URL = "静态常量";

    //静态变量 准备阶段 赋值为null，初始化阶段 赋值
    public static String URL2 = "静态变量";

    //变量 初始化赋值
    public String URL3 = "变量";

    //静态代码块 准备阶段赋值
    static {
        System.out.println(URL);
        System.out.println(URL2);
        System.out.println("静态代码块");
    }

    //普通代码块 初始化赋值
    {
//        System.out.println(URL2);
        System.out.println(URL3);
        System.out.println("普通代码块");
    }

    //构造器 初始化赋值
    public test01(){
        System.out.println("构造器");
    }

    public static void main(String[] args) {

        new test01();
    }
}
