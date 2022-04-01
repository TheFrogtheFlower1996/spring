package com.zh.starter;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zh
 * @date 2022/3/29 14:44
 * @description:说明 Spring Task 定时任务测试
 */
public class Starter05 {
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring05.xml");

    }
}
