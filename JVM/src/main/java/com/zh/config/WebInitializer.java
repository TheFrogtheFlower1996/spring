package com.zh.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author zh
 * @date 2022/4/26 13:48
 * @description:说明
 *
 * 实现 WebApplicationInitializer 接口，onStartup可以在web应用启动时被加载
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //加载应用上下文
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        //登记注册MVC配置类
        applicationContext.register(MvcConfig.class);
        //设置 ServletContext 上下文环境
        applicationContext.setServletContext(servletContext);
        //配置转发器 Dispatcher
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet());
        // 映射地址
        servlet.addMapping("/");
        //启动实例化bean
        servlet.setLoadOnStartup(1);
    }
}
