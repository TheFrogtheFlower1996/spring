package com.zh.设计模式.创建型.工厂模式.工厂方法模式.抽象产品和具体产品;

/**
 * @author zh
 * @date 2022/6/26 22:44
 * @description:说明
 */
public class  ProductA extends Product{
    @Override
    public void show() {
        System.out.println("阿里 生产出了 产品A");
    }
}
