package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zh
 * @date 2022/4/26 14:34
 * @description:说明
 */
@Controller
public class HelloController {

    @RequestMapping("hello")
    public @ResponseBody String hello(){
        return "hello";
    }
}
