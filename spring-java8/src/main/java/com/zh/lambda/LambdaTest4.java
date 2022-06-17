package com.zh.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author zh
 * @date 2022/6/16 19:16
 * @description:说明 函数式接口使用场景2 断言式
 */
public class LambdaTest4 {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7);

        System.out.println("------------匿名内部类方式 -----------");
        Predicate<Integer> pre = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 4;
            }
        };

        System.out.println("------------lambda表达式方式-----------");
        Predicate<Integer> pre2 = (i) -> {
            return i < 4;
        };

        System.out.println("------------lambda表达式方式 升级1-----------");
        Predicate<Integer> pre3 = i -> i < 4;

        System.out.println("------------lambda表达式方式 升级2-----------");
        list.removeIf(i -> i < 4);

//        list.removeIf(pre);
//        list.removeIf(pre2);

        list.forEach(i -> System.out.println(i));


    }
}
