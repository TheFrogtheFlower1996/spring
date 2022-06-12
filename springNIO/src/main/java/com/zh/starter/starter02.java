package com.zh.starter;

import com.zh.config.IocConfig02;
import com.zh.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zh
 * @date 2022/4/26 9:56
 * @description:说明
 */
public class starter02 {
    public static void main(String[] args) {

        //通过配置类获得上下文环境
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig02.class);

        //得到配置类对象
        IocConfig02 bean = applicationContext.getBean(IocConfig02.class);
        IocConfig02 bean02 = applicationContext.getBean(IocConfig02.class);
        System.out.println(bean);
        System.out.println(bean02);

        //调用方法，得到AccountDao对象
        AccountDao accountDao = bean.accountDao();
        AccountDao accountDao02 = bean02.accountDao();
        System.out.println(accountDao);
        System.out.println(accountDao02);


    }
}
