package com.zh.jvmtest;

/**
 * @author zh
 * @date 2022/6/17 16:39
 * @description:说明 测试类加载器
 */
public class test02 {
    public static void main(String[] args) {

        System.out.println("类加载器："+ Fu.class.getClassLoader());
    }
}
