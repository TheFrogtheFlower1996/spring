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
public class Test02 {
    public static void main(String[] args) {

        Person2 person = new Person2();
        person.getInfo(new Email2());
        person.getInfo(new Weixin());

    }
}

//定义接口
interface IReceiver {
    String getInfo();
}

//定义实现类 Email
class Email2 implements IReceiver{

    @Override
    public String getInfo() {
        return "Email 发送消息";
    }
}

//定义实现类 Weixin
class Weixin implements IReceiver{

    @Override
    public String getInfo() {
        return "Weixin 发送消息";
    }
}

//定义Person类与接口IReceiver发生依赖
class Person2 {
    public void getInfo(IReceiver iReceiver){
        System.out.println(iReceiver.getInfo());
    }
}





