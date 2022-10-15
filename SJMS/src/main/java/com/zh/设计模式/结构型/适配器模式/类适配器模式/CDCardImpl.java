package com.zh.设计模式.结构型.适配器模式.类适配器模式;

/** 目标 */
public class CDCardImpl implements CDCard{
    @Override
    public String CDRead() {
        String msg = "CDCard Read !";
        return msg;
    }

    @Override
    public void CDWrite(String msg) {
        System.out.println("CDCard write: " + msg);
    }
}
