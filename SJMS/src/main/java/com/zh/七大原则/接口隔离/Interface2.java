package com.zh.七大原则.接口隔离;

/**
 * @author zh
 * @date 2022/6/21 14:37
 * @description:说明
 */
public class Interface2 {
    public static void main(String[] args) {

        A1 a1 = new A1();
        a1.depend01(new B1()); //A类通过接口去依赖（使用）B类
        a1.depend02(new B1());
        a1.depend03(new B1());

        C1 c1 = new C1();
        c1.depend01(new D1());
        c1.depend04(new D1());
        c1.depend05(new D1());

    }
}

interface Interface02 {

    void test01();
}
interface Interface03 {
    void test02();
    void test03();
}
interface Interface04 {
    void test04();
    void test05();
}


class B1 implements Interface02,Interface03{

    @Override
    public void test01() {
        System.out.println("B test01 实现了接口");
    }

    @Override
    public void test02() {
        System.out.println("B test02 实现了接口");
    }

    @Override
    public void test03() {
        System.out.println("B test03 实现了接口");
    }
}

class D1 implements Interface04,Interface02{

    @Override
    public void test01() {
        System.out.println("D test01 实现了接口");
    }

    @Override
    public void test04() {
        System.out.println("D test04 实现了接口");
    }

    @Override
    public void test05() {
        System.out.println("D test05 实现了接口");
    }
}

class A1{

    public void depend01(Interface02 i){
        i.test01();
    }
    public void depend02(Interface03 i){
        i.test02();
    }
    public void depend03(Interface03 i){
        i.test03();
    }
}

class C1{

    public void depend01(Interface02 i){
        i.test01();
    }
    public void depend04(Interface04 i){
        i.test04();
    }
    public void depend05(Interface04 i){
        i.test05();
    }
}