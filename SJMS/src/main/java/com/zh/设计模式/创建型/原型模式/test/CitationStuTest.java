package com.zh.设计模式.创建型.原型模式.test;

public class CitationStuTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        CitationStu cs = new CitationStu();

        //创建对象stu
        Student stu = new Student();
        stu.setName("张三");
        cs.setStu(stu);

        cs.show();//张三同学，获得奖状

        //获取克隆对象
        CitationStu clone = cs.clone();

        //获取对象stu1
        Student stu1 = clone.getStu();
        stu1.setName("李四");

        System.out.println("stu 和 stu1 是否是同一个对象："+ (stu == stu1)); //true

        cs.show();//李四同学，获得奖状
        clone.show();//李四同学，获得奖状


    }
}
