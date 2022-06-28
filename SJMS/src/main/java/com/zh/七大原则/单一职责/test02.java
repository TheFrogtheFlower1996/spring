package com.zh.七大原则.单一职责;

/**
 * @author zh
 * @date 2022/6/21 11:28
 * @description:说明 单一原则举例
 */
public class test02 {
    public static void main(String[] args) {

        VehicleRoad vehicleRoad = new VehicleRoad();
        vehicleRoad.run("汽车");

        VehicleAir vehicleAir = new VehicleAir();
        vehicleAir.run("飞机");

        new VehicleWriter().run("游艇");
    }
}

/**
 * 方式2
 *  分解为不同的类 内存资源消耗大
 *
 * */
class VehicleRoad{
    public void run(String s){
        System.out.println(s + " 在公路上跑");
    }
}
class VehicleAir{
    public void run(String s){
        System.out.println(s + " 在天上飞");
    }
}
class VehicleWriter{
    public void run(String s){
        System.out.println(s + " 在水里游");
    }
}
