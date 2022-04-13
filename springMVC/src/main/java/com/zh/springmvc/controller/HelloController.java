package com.zh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zh
 * @date 2022/4/7 11:25
 * @description:说明
 */
@Controller
public class HelloController {

    /**
     * 控制器方法：访问路径：hello.do
     *
     * */
    @RequestMapping("hello")
    public ModelAndView hello(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","hello spring mvc");

        //设置视图
        modelAndView.setViewName("hello");

        return modelAndView;
    }
}
