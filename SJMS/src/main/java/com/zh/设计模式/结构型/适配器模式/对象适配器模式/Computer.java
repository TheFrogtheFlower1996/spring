package com.zh.设计模式.结构型.适配器模式.对象适配器模式;

/***
 * 计算机类
 * */
public class Computer {

    //从CD卡中读取记录
    public String readCD(CDCard cdCard){
        if (cdCard == null){
            throw new NullPointerException("cd is not null");
        }
        return cdCard.CDRead();
    }

    //向CD卡中写入信息

}
