package com.zh.starter;

import com.zh.dao.IUserDao;
import com.zh.service.UseService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zh
 * @date 2022/3/28 14:27
 * @description:说明
 */
public class Starter03 {
    public static void main(String[] args) {

        BeanFactory bf = new ClassPathXmlApplicationContext("spring02.xml");

        UseService useService = (UseService) bf.getBean("useService");

        useService.test1();
    }
}
