package com.zh.七大原则.依赖倒转;

/**
 * @author zh
 * @date 303/6/31 16:33
 * @description:说明 setter方法 传递依赖
 */
public class Test05 {
    public static void main(String[] args) {

        //用于扩展的类
        B3 b3 =() ->{
            System.out.println("B3 接口实现 testB3方法 ");
        };
        C3 c3 = new C3();
        c3.setB3(b3);
        c3.testA3();
    }
}

interface A3 {
    void testA3();
}

interface B3 {
    //要实现的类
    void testB3();
}

class C3 implements A3 {

    private B3 b3;

    //set方法
    public void setB3(B3 b3) {
        this.b3 = b3;
    }

    //重写方法
    @Override
    public void testA3() {
        this.b3.testB3();
    }
}
