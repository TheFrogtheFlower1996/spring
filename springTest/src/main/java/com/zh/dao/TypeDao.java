package com.zh.dao;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author zh
 * @date 2022/3/28 9:35
 * @description:说明
 */
public class TypeDao {


    public void test1(){
        System.out.println("TypeDao");
    }

    //bean对象销毁方法
    public void destroy(){
        System.out.println("bean对象销毁方法 destroy");
    }
}
