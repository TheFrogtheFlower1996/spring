package com.zh.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zh
 * @date 2022/4/13 10:59
 * @description:说明 拦截器实现 方式一（实现接口） HandlerInterceptor
 *  preHandle方法 表示 在目标方法（Handler）执行前 执行
 *      如果返回true，表示执行目标方法，false则不执行
 *  postHandle 在目标方法（Handler）执行后，视图生成前 执行
 *  afterCompletion 在目标方法（Handler）执行后，视图生成后 执行
 */
public class MyInterceptor01 implements HandlerInterceptor {

    /**
     * 在目标方法（Handler）执行前 执行
     *      如果返回true，表示执行目标方法，false则不执行
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("MyInterceptor01 --> preHandle方法 表示 在目标方法（Handler）执行前 执行");

//        return HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
    }

    /**
     * 在目标方法（Handler）执行后，视图生成前 执行
     *
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("MyInterceptor01 --> postHandle 在目标方法（Handler）执行后，视图生成前 执行");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在目标方法（Handler）执行后，视图生成后 执行
     *
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("MyInterceptor01 --> afterCompletion 在目标方法（Handler）执行后，视图生成后 执行");

//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
