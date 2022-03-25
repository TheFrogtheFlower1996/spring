package com.zh;

import com.zh.dao.UserDao;
import com.zh.factory.MyClassPathXmlApplication;
import com.zh.factory.MyFactory;

/**
 * @author zh
 * @date 2022/3/25 15:26
 * @description:说明
 */
public class Starter {
    public static void main(String[] args) {

        //得到工厂类
        MyFactory myFactory = new MyClassPathXmlApplication("spring.xml");
        UserDao dao =(UserDao) myFactory.getBean("userDao");
        dao.test();
    }
}
