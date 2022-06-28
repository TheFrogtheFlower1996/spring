package com.zh.七大原则.里式替换;

/**
 * @author zh
 * @date 2022/6/21 21:17
 * @description:说明 里式替换
 */
public class test01 {
    public static void main(String[] args) {

        A a = new A();
        int a1 = a.add(1, 2);

        B b = new B();
        int a2 = b.add(1, 2);

        System.out.println(a1);
        System.out.println(a2);
    }

}

class A {

    public int add(int n,int m){
        return n+m;
    }
}

//B继承A，重写方法
class B extends A {

    @Override
    public int add(int n, int m) {
        return n-m;
    }
}
