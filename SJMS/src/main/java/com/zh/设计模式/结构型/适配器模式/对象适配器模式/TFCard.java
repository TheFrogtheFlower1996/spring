package com.zh.设计模式.结构型.适配器模式.对象适配器模式;
/** 适配者接口 */
public interface TFCard {

    /** TFCard read */
    String TFread();

    /** TFCard write */
    void TFwrite(String msg);
}
