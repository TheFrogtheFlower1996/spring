package com.zh.jvmtest;

import java.math.BigDecimal;

/**
 * @author zh
 * @date 2022/6/19 21:07
 * @description:说明
 */
public class Order {

    private int id;
    private String name;
    private BigDecimal money;

    private byte[] bytes = new byte[1024*1024]; //1024kb=1m

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
