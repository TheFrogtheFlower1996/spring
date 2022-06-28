package com.zh.设计模式.创建型.单例模式.饿汉式静态变量;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zh
 * @date 2022/6/25 16:47
 * @description:说明 Runtime 简单使用
 */
public class RuntimeDemo {
    public static void main(String[] args) throws IOException {

        //饿汉式 静态变量
        //通过静态方法 获得该类对象
        Runtime runtime = Runtime.getRuntime();

        //exec 参数需要是一个命令
        Process process = runtime.exec("ipconfig");
        //获取输入流
        InputStream inputStream = process.getInputStream();
        byte[] bytes = new byte[1024*1024*100];
        int len = inputStream.read(bytes);//读到的字节个数
        System.out.println(new String(bytes,0,len,"GBK"));



    }
}
