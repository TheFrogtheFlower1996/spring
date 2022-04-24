package com.zh.starter;

import com.zh.controller.TestController;
import com.zh.dao.TypeDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zh
 * @date 2022/3/28 16:12
 * @description:说明
 */
public class Starter04 {
    public static void main(String[] args) {

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring04.xml");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring04.xml");

//        TypeDao typeDao = (TypeDao) beanFactory.getBean("typeDao");
/*        System.out.println(typeDao);

        TypeDao typeDao2 = (TypeDao) beanFactory.getBean("typeDao");
        System.out.println(typeDao2);*/

        AbstractApplicationContext aac = new ClassPathXmlApplicationContext("spring04.xml");
        aac.close();
    }
}
