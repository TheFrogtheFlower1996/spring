package com.zh.starter;

import com.zh.service.AddService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zh
 * @date 2022/3/31 16:51
 * @description:说明
 */
public class StarterAOP {
    public static void main(String[] args) {


        BeanFactory beanFactory= new ClassPathXmlApplicationContext("springAOP.xml");
        AddService addService = (AddService) beanFactory.getBean("addService");
        addService.add();
    }
}
