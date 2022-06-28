package com.zh.七大原则.依赖倒转;

/**
 * @author zh
 * @date 2022/6/21 16:19
 * @description:说明 接口传递 依赖关系
 */
public class Test03 {
    public static void main(String[] args) {
        C c = new C();
        B b = () ->{
            System.out.println("testB 被自定义实现");
        };
        c.testA(b);
    }
}


interface A {
    void testA(B b);
}

interface B {
    //正在被实现的方法
    void testB();
}

class C implements A {
    @Override
    public void testA(B b) {
        b.testB();
    }
}