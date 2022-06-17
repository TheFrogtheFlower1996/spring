package com.zh.lambda;

/**
 * @author zh
 * @date 2022/6/15 22:38
 * @description:说明
 */
public class LambdaTest2 {
    public static void main(String[] args) {

        Fuu fuu = (int m,int n) ->{
            return m+n;
        };
        int i = fuu.add(1, 2);
        System.out.println("i = "+i);


    }
}

interface Fuu{
    int add(int m,int n);
}
