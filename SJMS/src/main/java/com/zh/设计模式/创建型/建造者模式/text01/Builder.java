package com.zh.设计模式.创建型.建造者模式.text01;

/** 抽象建造者 */
public abstract class Builder {

    /**抽象产品*/
    protected Computer computer = new Computer();

    /** 抽象CPU方法 */
    public abstract void setCPU();

    /** 抽象内存方法 */
    public abstract void setMemory();

    /** 抽象显卡方法 */
    public abstract void setGraphicsCard();

    //TODO 添加产品抽象方法

    /** 抽象组装电脑方法 */
    public abstract Computer createComputer();

}
