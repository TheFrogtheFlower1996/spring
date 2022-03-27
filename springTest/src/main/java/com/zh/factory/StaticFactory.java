package com.zh.factory;

import com.zh.service.AccountService;

/**
 * @author zh
 * @date 2022/3/27 22:14
 * @description:说明 定义静态工厂类
 */
public class StaticFactory {

    /**
     *@创建人 zh
     *@创建时间 2022/3/27
     *@参数 
     *@返回值 
     *@描述 定义静态方法，返回需要实例化的Bean对象
     */
    
    public static AccountService accountService(){
        return new AccountService();
    }
}
