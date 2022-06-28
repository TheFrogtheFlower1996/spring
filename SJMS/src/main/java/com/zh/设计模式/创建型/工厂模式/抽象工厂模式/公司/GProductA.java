package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.公司;

/**
 * @author zh
 * @date 2022/6/26 23:18
 * @description:说明 抽象公司的产品
 */
public class GProductA extends ProductA{
    @Override
    public void show() {
        System.out.println("阿里公司 生产了 支付宝");
    }
}
