package com.zh.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author zh
 * @date 2022/6/16 19:16
 * @description:说明 函数式接口使用场景 list.forEach 遍历
 */
public class LambdaTest3 {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7);

        System.out.println("------------匿名内部类方式 遍历-----------");

        //匿名内部类
        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        };

        list.forEach(con);

        System.out.println("------------lambda表达式方式 遍历 -----------");

        //lambda表达式
        Consumer<Integer> con1 = (i)->{
            System.out.println(i);
        };
        list.forEach(con1);

        System.out.println("------------ lambda表达式方式 遍历 升级1 -----------");
        Consumer<Integer> con2 = i2-> System.out.println(i2);
        list.forEach(con2);

        System.out.println("------------ lambda表达式方式 遍历 升级2 -----------");
        list.forEach(i2-> System.out.println(i2));

    }
}
