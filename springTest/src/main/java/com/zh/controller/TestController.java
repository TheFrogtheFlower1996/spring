package com.zh.controller;

import com.zh.service.TestService;
import com.zh.utils.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author zh
 * @date 2022/3/28 16:08
 * @description:说明
 */
@Controller
public class TestController {

    @Resource
    private TestService testService;

    @Autowired
    private TestUtil testUtil;

    public void test(){
        System.out.println("TestController...");
        testService.test();
        testUtil.test();
    }
}
