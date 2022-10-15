package com.zh.设计模式.结构型.适配器模式.类适配器模式;
/** 目标接口 */
public interface CDCard {

    /** CDCard read */
    String CDRead();

    /** CDCard write */
    void CDWrite(String msg);
}
