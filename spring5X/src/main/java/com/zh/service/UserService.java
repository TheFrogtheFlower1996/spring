package com.zh.service;

import com.zh.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zh
 * @date 2022/4/22 11:36
 * @description:说明
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void userTest(){

        System.out.println("UserService....");
        userDao.testDao();
    }
}
