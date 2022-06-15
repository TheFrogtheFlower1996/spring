package com.zh.channel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zh
 * @date 2022/6/14 11:12
 * @description:说明 Channel通道测试
 */
public class ChannelTest {

    /**
     * 例5：通道数据复制
     * */
    @Test
    public void test4() throws Exception {
        //字节管道
        FileInputStream inputStream = new FileInputStream("data01.txt");
        FileOutputStream outputStream = new FileOutputStream("data02.txt");

        //管道
        FileChannel ic = inputStream.getChannel();
        FileChannel oc = outputStream.getChannel();

        //复制管道信息
//        oc.transferFrom(ic,ic.position(),ic.size());
        ic.transferTo(ic.position(),ic.size(),oc);
        ic.close();
        oc.close();

    }

    /**
     * 例4：分散（Scatter）和聚集（Gather）
     *
     * */
    @Test
    public void test3() throws Exception {
        //字节管道
        FileInputStream inputStream = new FileInputStream("data01.txt");
        FileOutputStream outputStream = new FileOutputStream("data02.txt");

        //管道
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();

        //定义多个缓冲区做数据分散
        ByteBuffer buffer1 = ByteBuffer.allocate(4);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {buffer1,buffer2};

        //从管道中读取数据分散到各个缓冲区
        inputStreamChannel.read(buffers);

        //查询各个缓冲区是否读取到数据
        for (ByteBuffer buffer : buffers) {
            buffer.flip();
            System.out.println(new String(buffer.array(),0,buffer.remaining()));
        }
        //聚合写入通道
        outputStreamChannel.write(buffers);
        inputStreamChannel.close();
        outputStreamChannel.close();
        System.out.println("分散 聚合 成功");
    }

    /**
     * 文件复制
     * */
    @Test
    public void copy() throws Exception {

        //源文件
        File srcFile = new File("C:\\Users\\13717\\Desktop\\ABC.txt");
        File destFile = new File("C:\\Users\\13717\\Desktop\\123.txt");

        //定义字节输入流
        FileInputStream inputStream = new FileInputStream(srcFile);
        //定义字节输出流
        FileOutputStream outputStream = new FileOutputStream(destFile);

        //定义通道
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();

        //定义一个缓冲区Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true){
            //先清空缓存池，再把数据放入缓冲区
            buffer.clear();

            //读取一次
            int flag = inputStreamChannel.read(buffer);
            if (flag == -1){
                break;
            }
            //已读取进通道，写出数据
            buffer.flip();
            outputStreamChannel.write(buffer);
        }
        inputStreamChannel.close();
        outputStreamChannel.close();
        System.out.println("复制成功");

    }

    /**
     * 例2：将data.txt文件读取并打印在控制台
     * */
    @Test
    public void read() throws Exception {

        //定义 文件字节输入流 与源文件接通
        FileInputStream fis = new FileInputStream("data01.txt");
        //定义通道
        FileChannel channel = fis.getChannel();
        //定义缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //读取数据到缓冲区
        channel.read(buffer);
        //更改为写操作
        buffer.flip();
        //读取出缓冲区数据
        String s = new String(buffer.array(),0,buffer.remaining());
        String s1 = new String(buffer.array(),0,buffer.limit());
        System.out.println(s);
        System.out.println(s1);


    }

    /**
     * 例1：将字符数组写入data.txt文件
     * */
    @Test
    public void test01(){

        try {
            //字节输出流通向文件
            FileOutputStream fos = new FileOutputStream("data01.txt");
            //定义通道
            FileChannel channel = fos.getChannel();
            //分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("hello,java !!!".getBytes());
            //切换写模式
            buffer.flip();
            channel.write(buffer);
            channel.close();;
            System.out.println("写出成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
