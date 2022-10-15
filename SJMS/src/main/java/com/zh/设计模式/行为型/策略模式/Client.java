package com.zh.设计模式.行为型.策略模式;

public class Client {
    public static void main(String[] args) {

        //定义具体策略类（具体节日促销活动）
        ConcreteStrategyA strategyA = new ConcreteStrategyA();
        ConcreteStrategyB strategyB = new ConcreteStrategyB();

        //定义环境类
        Context context = new Context(strategyA);
        Context context1 = new Context(strategyB);

        //展示具体策略类的促销活动
        context.show();
        context1.show();


    }
}
