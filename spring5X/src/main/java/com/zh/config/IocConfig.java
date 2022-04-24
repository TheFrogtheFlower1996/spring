package com.zh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zh
 * @date 2022/4/22 11:38
 * @description:说明
 */
@Configuration //声明当前类是配置类，相当于xml配置文件
/**
 * 扫描器：
 * 扫描包范围，会去扫描指定包下面的 @Controller、@Service、@Repository、@Component注解
 *
 * */
@ComponentScan("com.zh")
public class IocConfig {


}
