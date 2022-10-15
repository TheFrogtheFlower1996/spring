package com.zh.设计模式.行为型.观察者模式;

/**
 * 客户端
 * */
public class Client {
    public static void main(String[] args) {

        //定义观察者主题
        ConcreteSubject subject = new ConcreteSubject();
        //定义具体观察者
        WeiUser user1 = new WeiUser("张三");

        //主题添加观察者
        subject.attach(user1);
        //主题更新提醒
        subject.notify("微信公众号更新啦！快来看看啊！");
    }
}
