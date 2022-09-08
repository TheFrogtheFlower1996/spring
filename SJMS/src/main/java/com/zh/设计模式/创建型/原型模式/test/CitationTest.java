package com.zh.设计模式.创建型.原型模式.test;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        Citation citation = new Citation();// 1）创建原型对象

        Citation clone = citation.clone();
        clone.setName("张三");
        clone.show();//张三同学，获得奖状

        Citation clone1 = citation.clone();
        clone1.setName("李斯");
        clone1.show();//李斯同学，获得奖状
    }
}
