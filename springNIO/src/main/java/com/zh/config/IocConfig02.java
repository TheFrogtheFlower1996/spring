package com.zh.config;

import com.zh.dao.AccountDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zh
 * @date 2022/4/26 9:55
 * @description:说明
 */
@Configuration
@ComponentScan("com.zh")
public class IocConfig02 {

    //实例化bean对象
    @Bean //注入到IOC容器进行维护，AccountDao对象只创建一次
    public AccountDao accountDao(){
        return new AccountDao();
    }

}
