package com.zh.设计模式.创建型.工厂模式.工厂方法模式;

import com.zh.设计模式.创建型.工厂模式.工厂方法模式.抽象产品和具体产品.Product;
import com.zh.设计模式.创建型.工厂模式.工厂方法模式.抽象工厂和具体工厂.FactoryA;

/**
 * @author zh
 * @date 2022/6/26 22:51
 * @description:说明
 */
public class Client {
    public static void main(String[] args) {

        //客户要产品A 通过工厂A 得到产品A对象
        FactoryA factoryA = new FactoryA();
        //通过方法getInstance() 得到产品A对象
        Product instance = factoryA.getInstance();
        instance.show();
    }
}
