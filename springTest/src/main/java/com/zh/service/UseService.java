package com.zh.service;

import com.zh.dao.IUserDao;
import com.zh.dao.UserDao01;

import javax.annotation.Resource;

/**
 * @author zh
 * @date 2022/3/25 10:38
 * @description:说明
 */
public class UseService {

    @Resource(name = "userDao02")
    private IUserDao iUserDao;

    public void test1(){
        System.out.println("UserService...");
        iUserDao.test();
    }
}
