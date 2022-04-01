package com.zh.starter;

import com.zh.service.TypeService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zh
 * @date 2022/3/28 10:05
 * @description:说明
 */
public class Starter02 {
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring02.xml");

        TypeService ts = (TypeService) beanFactory.getBean("typeService");

        ts.test();
    }
}
