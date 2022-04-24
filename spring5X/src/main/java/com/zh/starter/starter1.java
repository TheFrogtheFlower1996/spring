package com.zh.starter;

import com.zh.config.IocConfig;
import com.zh.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zh
 * @date 2022/4/22 11:44
 * @description:说明
 */
public class starter1 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.userTest();
    }
}
