package com.zh.service;

import com.zh.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zh
 * @date 2022/3/28 16:10
 * @description:说明
 */
@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public void test(){
        System.out.println("TestService...");
        testDao.test();
    }
}
