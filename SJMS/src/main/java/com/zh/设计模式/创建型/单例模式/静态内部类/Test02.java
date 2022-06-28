package com.zh.设计模式.创建型.单例模式.静态内部类;

import java.io.*;

/**
 * @author zh
 * @date 2022/6/25 15:51
 * @description:说明 通过序列化破坏单例模式
 */
public class Test02 {
    public static void main(String[] args) throws Exception{

        //写数据
//        writeObjectToFile();

        //读 两次读取出的对象不同
        readObjectFromFile();
        readObjectFromFile();
    }

    //向文件中写数据
    public static void writeObjectToFile() throws Exception {
        //获取单例对象
        A instance = A.getInstance();
        //创建输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\13717\\Desktop\\A.txt"));
        //写
        oos.writeObject(instance);
        //释放资源
        oos.close();
    }

    //读出文件中数据
    public static void readObjectFromFile() throws Exception {
        //输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\13717\\Desktop\\A.txt"));
        //读
        A a  = (A) ois.readObject();
        System.out.println(a);
        ois.close();
    }
}
