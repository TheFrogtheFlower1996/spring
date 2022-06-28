package com.zh.设计模式.创建型.工厂模式.工厂方法模式.例一;

/**
 * @author zh
 * @date 2022/6/25 18:17
 * @description:说明
 */
public class ACoffeeFactory implements CoffeeFactory{

    @Override
    public Coffee getInstance() {
        return new ACoffee();
    }
}
