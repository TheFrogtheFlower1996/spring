package com.zh.设计模式.创建型.单例模式.双重检查;

/**
 * @author zh
 * @date 2022/6/24 11:01
 * @description:说明 单例模式 双重检查
 */
public class Test01 {
    public static void main(String[] args) {

        A instance = A.getInstance();

    }
}

class A {

    private A(){}

    private static volatile A a;

    /**
     * 双重检查
     *
     * 1、第一次多个线程通过第一个if判断，其中一个线程走同步代码块，a==null，赋值实例对象
     * 2、第一个线程走完，其他线程判断同步代码块的第二个if，a!=null
     * 3、再有线程调用，走第一个if就会判断为 a!=null，也就不用走同步代码块
     *
     * 结论：解决线程安全，懒加载问题，同时也保证效率
     * */
    public static A getInstance(){
        if (a == null){
            synchronized (A.class){
                if (a == null){
                    a = new A();
                }
            }
        }
        return a;
    }
}
