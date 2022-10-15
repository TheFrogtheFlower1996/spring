package com.zh.设计模式.创建型.建造者模式.text01;

import lombok.Data;

/** 产品 */
@Data
public class Computer {

    /** CPU */
    private String cpu;

    /** 内存 */
    private String Memory;

    /** 显卡 */
    private String graphicsCard;

    //TODO 增加电脑属性

}
