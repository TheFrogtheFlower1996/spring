package com.zh.设计模式.创建型.工厂模式.简单工厂模式.接口和实现类;

/**
 * @author zh
 * @date 2022/6/26 22:19
 * @description:说明
 */
public class ProductA extends Product{
    @Override
    public void show() {
        System.out.println("工厂生成了 产品A");
    }
}
