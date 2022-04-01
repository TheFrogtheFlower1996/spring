package com.zh.cglibDynamicProxy;

import com.zh.statics.RentHouse;
import com.zh.statics.User;
import com.zh.statics.You;

/**
 * @author zh
 * @date 2022/3/31 10:13
 * @description:说明 Cglib 动态代理 测试
 */
public class CglibTest {
    public static void main(String[] args) {

/*        //目标对象
        RentHouse target = new You();
        //代理类对象
        CglibProxy cglibProxy = new CglibProxy(target);
        //代理对象
        RentHouse proxy = (RentHouse) cglibProxy.getProxy();

        String result = proxy.toRentHouse2("张哈哈");
        System.out.println("result："+result);*/

        //目标对象
        User user = new User();
        //代理类
        CglibProxy cglibProxy1 = new CglibProxy(user);
        //代理对象
        User user1 = (User) cglibProxy1.getProxy();
        //调用
        user1.toMarry();
    }
}
