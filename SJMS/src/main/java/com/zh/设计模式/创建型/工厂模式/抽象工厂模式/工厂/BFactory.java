package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.工厂;

import com.zh.设计模式.创建型.工厂模式.抽象工厂模式.公司.AbstractProduct;
import com.zh.设计模式.创建型.工厂模式.抽象工厂模式.公司.GProductB;

/**
 * @author zh
 * @date 2022/6/26 23:24
 * @description:说明
 */
public class BFactory extends Factory{
    @Override
    public AbstractProduct getInstance() {
        return new GProductB();
    }
}
