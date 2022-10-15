package com.zh.设计模式.创建型.建造者模式.text01;

/** 具体建造者 */
public class Dell extends Builder{

    @Override
    public void setCPU() {
        computer.setCpu("戴尔使用 因特尔i7cpu");
    }

    @Override
    public void setMemory() {
        computer.setMemory("戴尔使用 16G内存");
    }

    @Override
    public void setGraphicsCard() {
        computer.setGraphicsCard("戴尔使用 RTX3060显卡");
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}
