package com.zh.jvmtest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zh
 * @date 2022/6/19 21:02
 * @description:说明 堆溢出
 */
public class Heap {

    public static void main(String[] args) throws Exception{
        List list = new ArrayList<>();

        for (;;){
            Order order = new Order();
            order.setId(1);
            order.setName("张三");
            order.setMoney(new BigDecimal(9999));

            list.add(order);

            System.out.println(list.size());
        }
    }
}
