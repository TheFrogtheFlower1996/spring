package com.zh.设计模式.创建型.工厂模式.简单工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/24 21:49
 * @description:说明 静态工厂模式
 *  1、提供静态方法
 *  2、创建子类全部实例对象
 *  3、根据参数返回对应子类实例对象
 */
public class SimpleFactory {

    private static InterfaceFather jia(){
        //TODO 功能增强
        return new Jia();
    }
    private static InterfaceFather jian(){
        //TODO 功能增强
        return new Jian();
    }
    private static InterfaceFather chen(){
        //TODO 功能增强
        return new Chen();
    }
    private static InterfaceFather chu(){
        //TODO
        return new Chu();
    }


    //提供静态方法 返回值是接口对象
    public static InterfaceFather getFactory(String s){
        InterfaceFather interfaceFather = null;
        switch (s){
            case "+":
                interfaceFather = jia();
                break;
            case "-":
                interfaceFather = jian();
                break;
            case "*":
                interfaceFather = chen();
                break;
            case "/":
                interfaceFather = chu();
                break;
        }
        return interfaceFather;
    }
}
