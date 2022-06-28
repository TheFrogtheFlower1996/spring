package com.zh.设计模式.创建型.单例模式.静态内部类;

import java.lang.reflect.Constructor;

/**
 * @author zh
 * @date 2022/6/25 16:07
 * @description:说明 通过反射破环单例模式
 */
public class Test03 {
    public static void main(String[] args) throws Exception {
        //获取 字节码对象
        Class<A> aClass = A.class;
        //获取无参构造方法对象
        Constructor<A> cons = aClass.getDeclaredConstructor();
        //取消访问检查
        cons.setAccessible(true);
        //创建实例对象
        A a1 = cons.newInstance();
        A a2 = cons.newInstance();
        System.out.println(a1 == a2);
    }
}
