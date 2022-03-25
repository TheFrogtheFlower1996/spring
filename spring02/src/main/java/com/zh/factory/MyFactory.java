package com.zh.factory;

/**
 * @author zh
 * @date 2022/3/25 11:50
 * @description:说明 工厂模式：自定义工具类
 */
public interface MyFactory {

    //通过id属性值获取实例化对象
    public Object getBean(String id);
}
