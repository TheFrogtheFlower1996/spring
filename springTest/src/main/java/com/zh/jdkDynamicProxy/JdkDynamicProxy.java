package com.zh.jdkDynamicProxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @author zh
 * @date 2022/3/30 10:09
 * @description:说明 JDK动态代理
 */
public class JdkDynamicProxy {

    //目标对象
    private Object target;
    //带参构造传递目标对象
    public JdkDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 得到代理对象
     * */
    public Object getProxy(){
        Object object = null;
        /**
         * 通过调用Proxy代理类中的静态方法 newProxyInstance()，得到代理对象
         * */

        //定义了由哪个ClassLoader对象来生成的代理对象进行加载
        ClassLoader classLoader = this.getClass().getClassLoader();
        //要代理的对象提供一组什么接口
        Class[] interfaces = target.getClass().getInterfaces();

        //一个InvocationHandler接口，表示代理实例的调用处理程序实现的接口
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * 当代理对象被调用时 invoke方法会被调用一次
             * proxy 代理对象
             * method 目标对象方法
             * args 目标方法需要的参数
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());//toRentHouse
                System.out.println(args.length);
                System.out.println(args[0]);
                System.out.println("invoke...调用");

                /**
                 * 反射 invoke方法 调用目标对象方法
                 *  方法名.invoke(对象,方法需所需参数)
                 * */
                Object result = method.invoke(target, args);

                System.out.println("result："+result);
                return result;
            }
        };

        //调用方法，得到代理对象
        object = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        return object;
    }
}
