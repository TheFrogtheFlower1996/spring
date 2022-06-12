package com.zh.buffer;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * @author zh
 * @date 2022/6/12 17:48
 * @description:说明 对缓冲区Buffer的常用API进行案例实现
 */
public class BufferTest {

    @Test
    public void test03(){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        String s = "abcde";
        buffer.put(s.getBytes());

        buffer.flip();

        //读取数据
        byte[] bytes = new byte[2];
        buffer.get(bytes);
        String s1 = new String(bytes);
        System.out.println(s1);
        System.out.println(buffer.position());//返回数组当前读取位置 4
        System.out.println(buffer.limit());//返回数组的界限 5
        System.out.println(buffer.capacity());//返回数组容量大小 10
        System.out.println("------------");

        buffer.mark();//标记此刻位置 2

        byte[] bytes1 = new byte[2];
        buffer.get(bytes1);
        System.out.println(new String(bytes1));
        System.out.println(buffer.position());//返回数组当前读取位置 2
        System.out.println(buffer.limit());//返回数组的界限 5
        System.out.println(buffer.capacity());//返回数组容量大小 10
        System.out.println("------------");

        buffer.reset();//回到标记位置
        if (buffer.hasRemaining()){
            System.out.println(buffer.remaining());
        }


    }

    @Test
    public void test02(){
        //分配一个缓冲区，容量设置为10
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());//返回数组当前读取位置 0
        System.out.println(buffer.capacity());//返回数组容量大小 10
        System.out.println(buffer.limit());//返回数组的界限 10
        System.out.println("----------------------");
        //put 向缓冲区添加数据
        String s = "abc";
        byte[] bytes = s.getBytes();
        buffer.put(bytes);
        System.out.println(buffer.position());//返回数组当前读取位置 0
        System.out.println(buffer.capacity());//返回数组容量大小 10
        System.out.println(buffer.limit());//返回数组的界限 3
        System.out.println("----------------------");

        //clear 清除缓冲区的数据
        buffer.clear();
        System.out.println((char) buffer.get());
        System.out.println(buffer.position());//返回数组当前读取位置 0
        System.out.println(buffer.capacity());//返回数组容量大小 10
        System.out.println(buffer.limit());//返回数组的界限 10
    }

    @Test
    public void test01(){

        //分配一个缓冲区，容量设置为10
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.capacity());//返回数组容量大小 10
        System.out.println(buffer.position());//返回数组当前读取位置 0
        System.out.println(buffer.limit());//返回数组的界限 10
        System.out.println(buffer.hasRemaining());//缓冲区是否有值 true
        System.out.println("----------------------");

        //put 向缓冲区添加数据
        String s = "abc";
        byte[] bytes = s.getBytes();
        buffer.put(bytes);

        System.out.println(buffer.capacity());//返回数组容量大小 10
        System.out.println(buffer.position());//返回数组当前读取位置 3
        System.out.println(buffer.limit());//返回数组的界限 10
        System.out.println(buffer.hasRemaining());//缓冲区是否有值 true
        System.out.println("----------------------");

        //flip 将缓冲区的界限设置为当前位置，并将当前位置设置为0
        buffer.flip();
        System.out.println(buffer.capacity());//返回数组容量大小 10
        System.out.println(buffer.position());//返回数组当前读取位置 0
        System.out.println(buffer.limit());//返回数组的界限 3
        System.out.println("----------------------");

        //get 缓冲区的读取
        char c = (char) buffer.get();
        System.out.println(c);
        System.out.println(buffer.capacity());//返回数组容量大小 10
        System.out.println(buffer.position());//返回数组当前读取位置 1
        System.out.println(buffer.limit());//返回数组的界限 3
    }
}
