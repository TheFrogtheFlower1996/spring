package com.zh.springmvc.interceptor;

import com.zh.springmvc.po.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zh
 * @date 2022/4/13 13:35
 * @description:说明 非法请求拦截器 用户登录
 * 用户添加、修改、删除（需要登录，需要拦截访问判断是否登录）
 */
public class LoginAccessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //通过request对象获取session对象
        HttpSession session = request.getSession();
        //获取session作用域中的信息
        User user = (User) session.getAttribute("user");
        //判断对象是否为空（不为空，表示登录状态；否则为未登录状态）
        if (user == null){
            //未登录状态，跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }

        //登录状态，允许执行下去
        return true;
    }
}
