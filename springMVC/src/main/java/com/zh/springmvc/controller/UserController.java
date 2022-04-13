package com.zh.springmvc.controller;

import com.zh.springmvc.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zh
 * @date 2022/4/13 11:41
 * @description:说明 拦截器实例 非法访问拦截
 *  用户登录 （无须登录，不需要拦截）
 *  用户添加、修改、删除（需要登录，需要拦截访问判断是否登录）
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public String login(HttpServletRequest httpServletRequest, HttpSession session){
        //请求域
        httpServletRequest.setAttribute("msg","用户登录");

        //如果用户执行了登录状态，则设置用户信息到session作用域中（如果session作用域中的信息不为空，则表示登录状态，否则为未登录状态）
        User user = new User();
        user.setId(1);
        user.setName("admin");
        session.setAttribute("user",user);
        return "success";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("msg","用户add");
        return "success";
    }
    @RequestMapping("update")
    public String update(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("msg","用户update");
        return "success";
    }
    @RequestMapping("delete")
    public String delete(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("msg","用户delete");
        return "success";
    }
}
