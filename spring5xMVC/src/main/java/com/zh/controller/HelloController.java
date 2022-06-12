package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zh
 * @date 2022/4/26 11:45
 * @description:说明
 */
@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello(){

        return "hello";
    }
}
