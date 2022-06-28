package com.zh.七大原则.单一职责;

/**
 * @author zh
 * @date 2022/6/21 11:28
 * @description:说明 单一原则举例
 */
public class test03 {
    public static void main(String[] args) {

        Vehicle3 ve = new Vehicle3();
        ve.runAir("飞机");
        ve.runRoad("汽车");
        ve.runWriter("游艇");
    }
}

/**
 * 方式3 在类级别 并没有遵循 单一职责原理 只是对方法进行增加
 *      在方法级别 遵循 单一职责原理
 *
 * */
class Vehicle3{
    public void runRoad(String s){
        System.out.println(s + " 在公路上跑");
    }

    public void runAir(String s){
        System.out.println(s + " 在天上飞");
    }

    public void runWriter(String s){
        System.out.println(s + " 在水里游");
    }

}


