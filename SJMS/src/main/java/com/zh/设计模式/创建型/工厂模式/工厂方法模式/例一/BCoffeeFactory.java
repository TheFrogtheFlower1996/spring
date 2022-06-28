package com.zh.设计模式.创建型.工厂模式.工厂方法模式.例一;

/**
 * @author zh
 * @date 2022/6/25 18:26
 * @description:说明 工厂实现类，用于创建各种对象
 */
public class BCoffeeFactory implements CoffeeFactory{

    @Override
    public Coffee getInstance() {
        return new BCoffee();
    }
}
