package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/26 16:10
 * @description:说明 具体工厂
 */
public class AliFactory implements CompanyFactory{

    @Override
    public ProductZF getProductZF() {
        return new ZFZFB();
    }

    @Override
    public ProductSC getProductSC() {
        return new SCTB();
    }
}
