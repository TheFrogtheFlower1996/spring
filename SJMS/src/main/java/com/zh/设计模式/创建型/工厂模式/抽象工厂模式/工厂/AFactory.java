package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.工厂;

import com.zh.设计模式.创建型.工厂模式.抽象工厂模式.公司.AbstractProduct;
import com.zh.设计模式.创建型.工厂模式.抽象工厂模式.公司.GProductA;
import com.zh.设计模式.创建型.工厂模式.抽象工厂模式.公司.ProductA;

/**
 * @author zh
 * @date 2022/6/26 23:22
 * @description:说明 具体工厂 阿里工厂
 */
public class AFactory extends Factory{
    @Override
    public AbstractProduct getInstance() {
        return new GProductA();
    }
}
