package com.zh.lambda;

import java.util.Comparator;

/**
 * @author zh
 * @date 2022/6/15 21:47
 * @description:说明 lambda 简化匿名内部类
 */
public class LambdaTest {

    public static void main(String[] args) {

        //方式3：匿名内部类
        F f = new F() {
            @Override
            public void add() {
                System.out.println("匿名内部类方式 调用add()方法");
            }
        };
        f.add();

        //方式4：lambda表达式 ()相当于参数，{}相当于方法体内容
        F f1 = ()->{
            System.out.println("lambda表达式 调用add方法");
        };
        f1.add();

        Comparable comparable = (i)-> 1;
    }

    //方式2：使用内部类，重写接口的抽象方法
    class Z2 implements F{
        @Override
        public void add() {

        }
    }
}

//方式1：定义一个类，重写接口的抽象方法
class Z1 implements F{
    @Override
    public void add() {

    }
}

@FunctionalInterface
interface F{
    void add();
}
