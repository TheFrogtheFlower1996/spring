package com.zh.设计模式.创建型.工厂模式.工厂方法模式.例一;

/**
 * @author zh
 * @date 2022/6/25 18:33
 * @description:说明
 */
public class Client {
    public static void main(String[] args) {

        //创建咖啡店对象
        CoffeeClient client = new CoffeeClient();

        //传递具体工厂对象
        client.setCoffeeFactory(new ACoffeeFactory());

        //得到具体对象
        Coffee coffee = client.getCoffee();

        System.out.println(coffee.getName());
        coffee.add();

    }
}
