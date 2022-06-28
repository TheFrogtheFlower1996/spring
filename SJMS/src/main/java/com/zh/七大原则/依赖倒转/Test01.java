package com.zh.七大原则.依赖倒转;

/**
 * @author zh
 * @date 2022/6/21 15:36
 * @description:说明
 *
 * 问题：如果我们获取的对象是 短信 微信等，则需要新增类，同时Person也要重载方法
 *
 * 解决：引入一个抽象接口 IReceiver，表示接收者，这样Person类与接口IReceiver发生依赖，
 *      因为短信、微信属于接收的范围，他们可以各自实现IReceiver接口就ok，符合依赖倒转
 */
public class Test01 {
    public static void main(String[] args) {

        Person person = new Person();
        person.getInfo(new Email());

    }
}

class Person{
    public void getInfo(Email email){
        System.out.println(email.send());
    }
}

class Email{
    public String send(){
        return "Email 发送消息";
    }
}

