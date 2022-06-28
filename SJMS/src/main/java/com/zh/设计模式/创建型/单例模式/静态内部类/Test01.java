package com.zh.设计模式.创建型.单例模式.静态内部类;

import java.io.Serializable;

/**
 * @author zh
 * @date 2022/6/24 11:19
 * @description:说明 使用静态内部类 单例模式
 */
public class Test01 {
    public static void main(String[] args) {

        A instance = A.getInstance();
        System.out.println(instance);
    }
}

class A implements Serializable {

    private A(){}

    /**
     * 静态内部类
     * 1、类加载时不会被实例化
     * 2、第一次调用静态内部类中的静态属性，进行类的初始化，JVM会保证线程安全
     *
     * 结论：即保证 懒加载 线程安全 效率高
     * */
    private static class AInstance{
        private static final A INSTANCE = new A();
    }

    //静态方法，方法静态内部类中实例化对象
    public static A getInstance(){
        return AInstance.INSTANCE;
    }

    //当进行反序列化时，会自动调用该方法，将静态内部类的变量返回
    public Object readResolve() {
        return AInstance.INSTANCE;
    }


}
