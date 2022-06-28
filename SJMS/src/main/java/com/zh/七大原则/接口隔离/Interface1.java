package com.zh.七大原则.接口隔离;

/**
 * @author zh
 * @date 2022/6/21 14:37
 * @description:说明
 */
public interface Interface1 {

    void test01();
    void test02();
    void test03();
    void test04();
    void test05();
}


class B implements Interface1{

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

    @Override
    public void test04() {
        System.out.println("B test04 实现了接口");
    }

    @Override
    public void test05() {
        System.out.println("B test05 实现了接口");
    }
}

class D implements Interface1{

    @Override
    public void test01() {
        System.out.println("D test01 实现了接口");
    }

    @Override
    public void test02() {
        System.out.println("D test02 实现了接口");
    }

    @Override
    public void test03() {
        System.out.println("D test03 实现了接口");
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

class A{

    public void depend01(Interface1 i){
        i.test01();
    }
    public void depend02(Interface1 i){
        i.test02();
    }
    public void depend03(Interface1 i){
        i.test03();
    }
}

class C{

    public void depend01(Interface1 i){
        i.test01();
    }
    public void depend04(Interface1 i){
        i.test04();
    }
    public void depend05(Interface1 i){
        i.test05();
    }
}