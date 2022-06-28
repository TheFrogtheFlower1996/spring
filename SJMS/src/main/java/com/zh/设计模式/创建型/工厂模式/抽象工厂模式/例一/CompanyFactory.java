package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/26 15:52
 * @description:说明 抽象工厂 对产品进行抽象
 */
public interface CompanyFactory {

     ProductZF getProductZF();

     ProductSC getProductSC();
}
