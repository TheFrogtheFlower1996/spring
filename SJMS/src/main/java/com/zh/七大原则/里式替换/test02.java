package com.zh.七大原则.里式替换;

/**
 * @author zh
 * @date 2022/6/21 21:17
 * @description:说明 里式替换
 */
public class test02 {
    public static void main(String[] args) {

        B1 b1 = new B1();
        B1 b2 = new B1();
        int i1 = b1.add(10, 1);//调用父类加法方法
        int i2 = b2.addA1(10, 1);//调用A1减法方法

        System.out.println(i1);
        System.out.println(i2);
    }

}

//Fu基类 加法
class Fu{

    public int add(int m,int n){
        return n+m;
    }
}

//A1重写 为减法
class A1 extends Fu{
    @Override
    public int add(int m, int n) {
        return m-n;
    }
}

//B1不重写，可以用父类方法，但也想用A1方法
class B1 extends Fu{

    private A1 a1 = new A1();

    @Override
    public int add(int m, int n) {
        return super.add(m, n);
    }

    public int addA1(int a,int b){
        return this.a1.add(a,b);
    }
}