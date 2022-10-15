package com.zh.设计模式.结构型.适配器模式.类适配器模式;

/**
 * 适配器类
 * */
public class CDAdapterTF extends TFCardImpl implements CDCard{
    // adapter 读取 TFRead
    @Override
    public String CDRead() {
        System.out.println("adapter read TFcard");
        String msg = TFread();
        return msg;
    }

    // CDWrite 写入 TFwrite
    @Override
    public void CDWrite(String msg) {
        TFwrite(msg);
    }


    @Override
    public String TFread() {
        return super.TFread();
    }

    @Override
    public void TFwrite(String msg) {
        super.TFwrite(msg);
    }
}
