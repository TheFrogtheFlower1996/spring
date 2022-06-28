package com.zh.设计模式.创建型.工厂模式.工厂方法模式.例一;

/**
 * @author zh
 * @date 2022/6/25 18:14
 * @description:说明 抽象工厂
 */
public interface CoffeeFactory {

    //抽象工厂方法 返回值是 具体咖啡类对象
    Coffee getInstance();
}
