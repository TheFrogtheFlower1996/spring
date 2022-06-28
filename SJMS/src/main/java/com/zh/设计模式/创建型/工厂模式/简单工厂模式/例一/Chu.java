package com.zh.设计模式.创建型.工厂模式.简单工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/24 21:47
 * @description:说明
 */
public class Chu implements InterfaceFather {
    @Override
    public double getResult(double m, double n) throws Exception {
        if (n == 0){
            throw new Exception("除数不能为零");
        }
        return m/n;
    }
}
