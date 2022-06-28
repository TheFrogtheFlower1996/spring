package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/26 15:58
 * @description:说明 产品A 1
 */
public class ZFZFB extends ProductZF {
    @Override
    public String getProductName() {
        return "我是支付产品的 支付宝";
    }

    @Override
    public void toDoA() {
        System.out.println("支付宝 自定义动作");
    }
}
