package com.zh.factory;

import com.zh.service.UseService;

/**
 * @author zh
 * @date 2022/3/27 22:38
 * @description:说明 定义工厂类
 */
public class InstanceFactory {

    public UseService useService(){
        return new UseService();
    }
}
