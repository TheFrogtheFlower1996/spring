package com.zh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author zh
 * @date 2022/4/26 11:48
 * @description:说明
 */
@Configuration
@ComponentScan("com.zh")
@EnableWebMvc //启动MVC环境
public class MvcConfig {

    /**
     * 配置jsp 视图解析器
     * @Bean 将方法返回值交给IOC容器维护
     * */
    @Bean
    public InternalResourceViewResolver resourceViewResolver(){

        //初始化视图解析器对象
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //添加前缀 后缀
        resolver.setPrefix("/WEB-INF/jsp");
        resolver.setSuffix(".jsp");

        return resolver;
    }


}
