package com.zh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zh
 * @date 2022/4/7 14:53
 * @description:说明
 *
 * URL地址映射 @RequestMapping()
 * 1.映射单个地址配置
 * 2.映射多个地址配置
 * 3.设置类路径（作为访问和父路径）
 * 4.请求方式 （GET|POST|PUT|DELETE）
 * 5.参数路径 （@RequestMapping(params="参数名") 访问方式：类路径?参数）
 *
 */
@Controller
/**
 * 映射类路径
 * */
@RequestMapping("url")
public class UrlController {

    /**
     * 映射一个地址配置
     * */
    @RequestMapping("url01")
    public ModelAndView url01(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","url01方法");

        modelAndView.setViewName("hello");
        return modelAndView;
    }

    /**
     * 映射多个地址配置
     * */
    @RequestMapping({"url02_01","url02_02"})
    public ModelAndView url02(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","url02方法");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    /**
     * 请求方式 GET
     * */
    @RequestMapping(value = "url03",method = RequestMethod.GET)
    public ModelAndView url03(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","url03方法");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    /**
     * 参数路径
     * 访问地址：http://localhost:8080/springMVC/Url/url04.do?url
     * */
    @RequestMapping(value = "url04",params = "url")
    public ModelAndView url04(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","url04方法");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

}
