package com.zh.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author zh
 * @date 2022/3/31 16:05
 * @description:说明
 * 切面是切入点与通知的结合
 *      切入点：定义规则，定义切面要拦截哪些类哪些方法
 *      通知：方法拦截后要做什么事情
 */
@Component //将类交给IOC容器实例化
@Aspect //声明当前类是一个切面类
public class LogCut {


    /**
     * 定义切入点，通过 @Pointcut()注解 定义规则
     * 注：规则表达式的第一个位置表示方法的修饰范围
     *
     * 1.拦截所有的方法
     *     @Pointcut("execution(* *(..))")
     * 2.拦截所有共有的set方法
     *     @Pointcut("execution(public set*(..))")
     * 3.拦截 com.zh.service 包及其子包下面的所有类和所有方法
     *     @Pointcut("execution(* com.zh.service..*.*(..))")
     * 4.拦截 com.zh.service 包下面的所有类和所有方法
     *     @Pointcut("execution(* com.zh.service.*.*(..))")
     * */
    @Pointcut("execution(* com.zh.service.*.*(..))")
    public void cut(){
        System.out.println("cut...切面方法");
    }

    /**
     * 前置通知，应用在指定切点上，在目标方法执行前执行
     *
     * */
    @Before("cut()")
    public void before(){
//        System.out.println("前置通知...before");
    }

    /**
     * 返回通知，应用在指定切点上，在目标方法（无异常）返回后执行
     * */
    @AfterReturning("cut()")
    public void afterReturn(){
//        System.out.println("后置通知...afterReturn");
    }

    /**
     * 最终通知
     * */
    @After("cut()")
    public void after(){
//        System.out.println("最终通知...after");
    }

    @AfterThrowing(value = "cut()",throwing = "e")
    public void afterThrow(Exception e){
//        System.out.println("异常通知，原因："+e.getMessage());
    }

    /**
     * 环绕通知，需要显式调用对应的方法，否则无法指定方法（pjp.proceed()）
     *
     * */
    @Around("cut()")
    public Object around(ProceedingJoinPoint pjp){

        System.out.println("前置通知");
        Object result = null;

        try {
            result = pjp.proceed();
            System.out.println(pjp.getTarget());
            System.out.println(pjp.getSignature());
            System.out.println("返回通知");
        } catch (Exception e){
            System.out.println("异常通知..."+e.getMessage());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }

        return result;
    }



}
