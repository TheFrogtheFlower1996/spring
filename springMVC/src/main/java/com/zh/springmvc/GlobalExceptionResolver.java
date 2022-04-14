package com.zh.springmvc;

import com.zh.springmvc.exceptions.BusinessException;
import com.zh.springmvc.exceptions.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zh
 * @date 2022/4/14 14:21
 * @description:说明 全局统一异常
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    /**
     * httpServletRequest request请求对象
     * httpServletResponse response响应对象
     * handler 目标方法对象
     * e 异常对象
     * */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {

        //设置默认视图
        ModelAndView mv = new ModelAndView("error");
        //设置默认异常信息
        mv.addObject("ex","默认全局统一异常....");

        //判断是否是自定义异常
        if (e instanceof ParamsException){
            ParamsException pe = (ParamsException) e;
            pe.setCode(501);
            pe.setMsg("自定义参数异常");

            mv.setViewName("params_error");
            mv.addObject("pe",pe);
        }
        if (e instanceof BusinessException){
            mv.setViewName("business_error");
            BusinessException pe = (BusinessException) e;
            mv.addObject("pe",pe.getMsg());
        }

        return mv;
    }
}
