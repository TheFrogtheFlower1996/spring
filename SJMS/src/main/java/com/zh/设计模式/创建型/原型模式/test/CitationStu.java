package com.zh.设计模式.创建型.原型模式.test;

import lombok.Data;

@Data
public class CitationStu implements Cloneable {

    private Student stu;

    @Override
    public CitationStu clone() throws CloneNotSupportedException {
        return (CitationStu) super.clone();
    }

    public void show(){
        System.out.println(stu.getName() + "同学，获得奖状");
    }
}
