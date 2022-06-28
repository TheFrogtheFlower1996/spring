package com.zh.设计模式.创建型.工厂模式.抽象工厂模式.例一;

/**
 * @author zh
 * @date 2022/6/26 16:19
 * @description:说明
 */
public class BeforeClient {

    //定义抽象工厂变量
    private CompanyFactory cf;

    //set方法注入
    public void setCf(CompanyFactory cf){
        this.cf = cf;
    }



}
