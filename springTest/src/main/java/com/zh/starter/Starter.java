package com.zh.starter;

import com.zh.factory.InstanceFactory;
import com.zh.service.AccountService;
import com.zh.service.UseService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zh
 * @date 2022/3/25 11:01
 * @description:说明
 */
public class Starter {
    public static void main(String[] args) {

        //得到spring上下文环境，ApplicationContext接口代表Spring IOC容器，并负责实例化，配置和组装Bean
        BeanFactory ac = new ClassPathXmlApplicationContext("spring.xml");

        //得到被实例化的对象
        AccountService as = (AccountService) ac.getBean("accountService");

        UseService us = (UseService) ac.getBean("useService");

        as.test();
        us.test1();
    }
}
