package com.zh.设计模式.结构型.代理模式.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理工厂类：获取代理对象
 * **/
public class ProxyFactory {

    private Object target;
    //传递目标对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //代理工厂，返回代理对象
    public Object getProxyObject(){
        Object obj =  Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /**
                         *  反射 invoke方法 调用目标对象方法
                         *  方法名.invoke(对象,方法需所需参数)7
                         * */
                        Object object = method.invoke(target, args);
                        return object;
                    }
                }
        );
        return obj;
    }
}
