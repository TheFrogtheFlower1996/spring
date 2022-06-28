package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.工厂;

import com.zh.设计模式.创建型.工厂模式.抽象工厂模式.公司.AbstractProduct;


/**
 * @author zh
 * @date 2022/6/26 23:21
 * @description:说明 抽象工厂
 */
public abstract class Factory {
    public abstract AbstractProduct getInstance();
}
