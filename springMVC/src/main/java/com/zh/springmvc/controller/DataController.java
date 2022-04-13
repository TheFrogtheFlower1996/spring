package com.zh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zh
 * @date 2022/4/8 13:49
 * @description:说明
 */
@Controller
public class DataController {

    /**
     * ModelAndView addObject("key","value")
     *
     * */
    @RequestMapping("data01")
    public ModelAndView test01(){

        ModelAndView modelAndView = new ModelAndView("data");
        //设置请求域 数据模型
        modelAndView.addObject("msg","通过 ModelAndView 对象设置请求域");

        return modelAndView;
    }

    /**
     * HttpServletRequest setAttribute("key","value")
     * HttpSession setAttribute("key","value")
     **/
    @RequestMapping("data02")
    public String test02(HttpServletRequest httpServletRequest, HttpSession session){
        //设置请求域 数据模型
//        httpServletRequest.setAttribute("msg","通过 HttpServletRequest 对象设置请求域");
        session.setAttribute("msg","通过 HttpSession 对象设置请求域");
        return "data";
    }





}
