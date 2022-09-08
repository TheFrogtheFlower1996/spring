package com.zh.设计模式.创建型.原型模式;

public class Realizetype implements Cloneable{

    public Realizetype(){
        System.out.println("具体的原型对象创建完成");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (Realizetype) super.clone();
    }
}
