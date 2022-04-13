package com.zh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zh
 * @date 2022/4/8 10:52
 * @description:说明
 */
@Controller
public class JumpController {

    /**
     * 请求转发 到页面
     *  使用forward：页面，此时会从项目的根路径（webapp目录）下查找指定页面
     *  如果传递参数，在页面中可以通过 ${param.参数名} el表达式获取对应参数值
     * */
    @RequestMapping("test01")
    public ModelAndView test01(String name){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","请求转>>>");

        //设置视图，默认请求转发
        modelAndView.setViewName("forward:index.jsp?name="+name);
        return modelAndView;
    }

    /**
     * 请求转发 到控制器
     * forward：控制器映射地址，请求到控制器映射方法上
     *
     * */
    @RequestMapping("test02")
    public ModelAndView test02(String name){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","请求转发>>>");

        //设置视图，默认请求转发
        modelAndView.setViewName("forward:hello");
        return modelAndView;
    }

    /**
     * 请求转发
     *      返回视图名字符串
     *      默认会从视图解析器设置的路径下查找（WEB-INF/jsp目录下查找）
     * 常用对象可以设置到方法的形参中，直接使用
     * */
    @RequestMapping("test03")
    public String test03(HttpServletRequest request){

        //设置数据模型
        request.setAttribute("msg","请求转发03");

        //默认访问路径是 WEB-INF/jsp
        //return "test01";

        //退回到webapp根目录，或者 "forward:index"
//        return "/../../index";
        return "forward:index.jsp";
    }

    /**
     * 重定向
     *      默认从项目根目录查找资源
     *      可以传递参数，传递中文参数无法获取，需要使用 RedirectAttributes对象设置
     *              redirectAttributes.addAttribute("name","张三");
     * */
    @RequestMapping("test04")
    public ModelAndView test04(RedirectAttributes redirectAttributes){

        ModelAndView modelAndView = new ModelAndView();
        //重定向中数据模型获取不到
        modelAndView.addObject("msg","重定向>>>");

        //设置中文参数
//        redirectAttributes.addAttribute("name","张三");

        //设置视图
        //modelAndView.setViewName("redirect:index.jsp");

        //重定向到控制器
        modelAndView.setViewName("redirect:hello");
        return modelAndView;
    }

    /**
     * 重定向 到页面
     *      默认到根目录下查找
     *      返回页面字符串
     *
     * */
    @RequestMapping("test05")
    public String test05(HttpServletRequest request){
        return "redirect:index.jsp";
    }



}
