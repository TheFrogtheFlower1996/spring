package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/26 15:59
 * @description:说明
 */
public class ZFWX extends ProductZF {

    @Override
    public String getProductName() {
        return "我是支付产品的 微信";
    }

    @Override
    public void toDoA() {
        System.out.println("微信 自定义动作");
    }
}
