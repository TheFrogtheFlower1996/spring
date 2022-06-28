package com.zh.jvmtest;

/**
 * @author zh
 * @date 2022/6/17 15:52
 * @description:说明
 */
public class Fu {
    // 静态常量 准备阶段 赋值
    public static final String URL = "父类 静态常量";

    //变量 初始化赋值
    public String URL3 = "父类 变量";

    //静态代码块 准备阶段赋值
    static {
        System.out.println(URL);
        System.out.println("父类 静态代码块");
    }

    //普通代码块 初始化赋值
    {
        System.out.println(URL3);
        System.out.println("父类 普通代码块");
    }

    //构造器 初始化赋值
    public Fu(){
        System.out.println("父类 构造器");
    }

}
