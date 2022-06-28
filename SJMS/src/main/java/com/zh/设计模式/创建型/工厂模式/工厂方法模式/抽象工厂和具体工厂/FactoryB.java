package com.zh.设计模式.创建型.工厂模式.工厂方法模式.抽象工厂和具体工厂;

import com.zh.设计模式.创建型.工厂模式.工厂方法模式.抽象产品和具体产品.Product;
import com.zh.设计模式.创建型.工厂模式.工厂方法模式.抽象产品和具体产品.ProductB;

/**
 * @author zh
 * @date 2022/6/26 22:51
 * @description:说明
 */
public class FactoryB extends Factory{
    @Override
    public Product getInstance() {
        return new ProductB();
    }
}
