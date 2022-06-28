package com.zh.设计模式.创建型.工厂模式.工厂方法模式.例一;

/**
 * @author zh
 * @date 2022/6/25 18:13
 * @description:说明 咖啡业务类
 */
public class CoffeeClient {

    //定义工厂变量
    private CoffeeFactory coffeeFactory;

    //set方法 传递具体工厂变量
    public void setCoffeeFactory(CoffeeFactory coffeeFactory){
        this.coffeeFactory = coffeeFactory;
    }

    //通过具体工厂 得到具体对象
    public Coffee getCoffee() {
        return coffeeFactory.getInstance();
    }
}
