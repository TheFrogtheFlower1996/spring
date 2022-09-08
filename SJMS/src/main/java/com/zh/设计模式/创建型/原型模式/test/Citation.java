package com.zh.设计模式.创建型.原型模式.test;

import lombok.Data;

@Data
public class Citation implements Cloneable{

    private String name;

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show(){
        System.out.println(name + "同学，获得奖状");
    }
}
