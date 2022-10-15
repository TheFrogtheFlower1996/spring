package com.zh.设计模式.结构型.装饰者模式.demo01;

public class Client {
    public static void main(String[] args) {

        //点分炒饭
        FastFood food = new FriedRice();
        System.out.println(food);

        //点份炒饭加鸡蛋
        food = new Egg(food);
        System.out.println(food.cost() + " " + food.getDesc());

        //点份炒饭加鸡蛋和培根
        food = new Bacon(food);
        System.out.println(food.cost() + " " + food.getDesc());

    }
}
