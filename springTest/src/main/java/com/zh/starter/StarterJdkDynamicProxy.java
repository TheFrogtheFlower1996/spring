package com.zh.starter;

import com.zh.jdkDynamicProxy.JdkDynamicProxy;
import com.zh.statics.RentHouse;
import com.zh.statics.You;

/**
 * @author zh
 * @date 2022/3/30 10:46
 * @description:说明 动态代理 启动类
 */
public class StarterJdkDynamicProxy {
    public static void main(String[] args) {

//        //目标对象
//        RentHouse target = new You();
//        //代理类
//        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(target);
//        //得到代理对象
//        RentHouse object = (RentHouse) jdkDynamicProxy.getProxy();
//
//        object.toRentHouse();

        //目标对象有返回值
        RentHouse target2 = new You();
        //动态代理类对象
        JdkDynamicProxy jdkDynamicProxy2 = new JdkDynamicProxy(target2);
        //得到代理对象
        RentHouse object2 = (RentHouse) jdkDynamicProxy2.getProxy();
        //代理对象调用
        object2.toRentHouse2("张三");

    }
}
