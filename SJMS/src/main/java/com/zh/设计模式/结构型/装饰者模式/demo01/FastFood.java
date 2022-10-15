package com.zh.设计模式.结构型.装饰者模式.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 抽象构件者（Component）
 * 抽象快餐类
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class FastFood {

    private float price;//价格
    private String desc;//描述

    /**
     * 计算金额方法
     * */
    public abstract float cost();
}
