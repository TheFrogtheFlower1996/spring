package com.zh.七大原则.依赖倒转;

/**
 * @author zh
 * @date 2022/6/21 16:32
 * @description:说明 构造器 传递依赖
 */
public class Test04 {
    public static void main(String[] args) {

        B2 b2 =() ->{
            System.out.println("B2 接口实现 testB2方法 ");
        };
        C2 c2 = new C2(b2);
        c2.testA2();

    }
}

interface A2 {
    void testA2();
}

interface B2 {
    //要实现的类
    void testB2();
}

class C2 implements A2 {

    private B2 b2;

    //构造器
    public C2(B2 b2) {
        this.b2 = b2;
    }

    @Override
    public void testA2() {
        this.b2.testB2();
    }
}
