package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/26 15:59
 * @description:说明
 */
public class SCPDD extends ProductSC {
    @Override
    public String getProductName() {
        return "我是商场产品的 拼多多";
    }

    @Override
    public void toDoB() {
        System.out.println("拼多多 自定义动作");
    }
}
