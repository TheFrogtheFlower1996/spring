package com.zh.设计模式.结构型.适配器模式.类适配器模式;

/** 适配者类 */
public class TFCardImpl implements TFCard{
    @Override
    public String TFread() {
        String msg = "TFCard read ！";
        return msg;
    }

    @Override
    public void TFwrite(String msg) {
        System.out.println("TFCard write: " + msg);
    }
}
