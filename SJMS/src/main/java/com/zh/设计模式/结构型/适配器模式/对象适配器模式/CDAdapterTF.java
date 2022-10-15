package com.zh.设计模式.结构型.适配器模式.对象适配器模式;

/**
 * 适配器类 聚合
 * */
public class CDAdapterTF  implements CDCard {

    private TFCard tfCard;

    public CDAdapterTF(TFCard tfCard){
        this.tfCard = tfCard;
    }

    // adapter 读取 TFRead
    @Override
    public String CDRead() {
        System.out.println("adapter read TFcard");
        String msg = tfCard.TFread();
        return msg;
    }

    // CDWrite 写入 TFwrite
    @Override
    public void CDWrite(String msg) {
        tfCard.TFwrite(msg);
    }

}
