package com.zh.设计模式.创建型.工厂模式.简单工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/24 21:47
 * @description:说明
 */
public class Chen implements InterfaceFather {
    @Override
    public double getResult(double m, double n) {
        return m*n;
    }
}
