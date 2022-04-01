package com.zh.cglibDynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zh
 * @date 2022/3/30 16:48
 * @description:说明 CGLIB 动态代理
 *      继承思想，代理类是目标类的子类，代理类对目标类中的方法进行重写
 */
public class CglibProxy {

    //目标对象
    private Object target;

    //通过带参构造器 获取目标对象
    public CglibProxy(Object target) {
        this.target = target;
    }

    /**
     * 获取代理对象
     *
     * */
    public Object getProxy(){
        //通过Enhancer对象的create()方法可以生成一个类，用于生成代理对象
        Enhancer enhancer = new Enhancer();
        //设置当前类的父类（将目标类作为代理类父类）
        enhancer.setSuperclass(target.getClass());
        //定义 方法拦截器
        MethodInterceptor interceptor = new MethodInterceptor() {
            /**
             * 代理过程 当代理对象调用方法时 intercept()方法会被执行
             * o 由CGLIB动态生成的代理类实例
             * method 目标方法
             * objects 方法所需要的参数
             * methodProxy 代理对象对方法的引用
             * */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("CGLIB...指定方法执行前");
                Object result = method.invoke(target, objects);
                System.out.println("CGLIB...指定方法执行后");
                return result;
            }
        };

        //设置拦截过程（调用目标对象的方法、增强用户行为）
        enhancer.setCallback(interceptor);

        //生成一个类
        return enhancer.create();
    }
}
