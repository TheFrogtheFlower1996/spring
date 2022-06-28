package com.zh.七大原则.单一职责;

/**
 * @author zh
 * @date 2022/6/21 11:28
 * @description:说明 单一原则举例
 */
public class test01 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

/**
 * 方式1
 * 在run方法中 违反了单一职责原则 需要分解为不同的类
 *
 * */
class Vehicle{
    public void run(String s){
        System.out.println(s + " 在公路上跑");
    }
}
