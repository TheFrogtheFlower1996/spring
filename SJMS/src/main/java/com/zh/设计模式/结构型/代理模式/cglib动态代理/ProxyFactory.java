package com.zh.设计模式.结构型.代理模式.cglib动态代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理对象工厂，用来生成代理对象
 * **/
public class ProxyFactory implements MethodInterceptor {

    //目标对象(父类)
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 获取代理对象方法
     * 1.调用 Enhancer类的 setSuperclass()方法，设置目标对象为代理对象父类
     * 2.调用 Enhancer类的 create()方法，生成代理对象
     * **/
    public Object getProxyObject(){
        //类似JDK代理中的Proxy类
        Enhancer enhancer = new Enhancer();
        //指定父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        Object proxyObject = enhancer.create();
        return proxyObject;
    }

    //重写拦截器，调用目标方法，实现功能增强
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理方法执行！！1");
        //调用目标对象方法
        Object obj = method.invoke(target, objects);
        return obj;
    }
}
