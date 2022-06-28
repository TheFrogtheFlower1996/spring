package com.zh.设计模式.创建型.工厂模式.简单工厂模式.简单工厂;

import com.zh.设计模式.创建型.工厂模式.简单工厂模式.接口和实现类.Product;
import com.zh.设计模式.创建型.工厂模式.简单工厂模式.接口和实现类.ProductA;
import com.zh.设计模式.创建型.工厂模式.简单工厂模式.接口和实现类.ProductB;

/**
 * @author zh
 * @date 2022/6/26 22:20
 * @description:说明 工厂类
 */
public class Factory {

    public static Product getInstance(String s){
        Product product = null;

        switch (s){
            case "A" :
                product = new ProductA();
                break;
            case "B" :
                product = new ProductB();
                break;
        }
        return product;
    }
}
