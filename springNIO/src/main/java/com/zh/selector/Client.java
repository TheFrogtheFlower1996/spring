package com.zh.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author zh
 * @date 2022/6/14 21:16
 * @description:说明 客户端 案例实现 - 基于NIO非阻塞通信
 */
public class Client {
    public static void main(String[] args) throws Exception {

        //获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        //切换非阻塞模式
        sChannel.configureBlocking(false);
        //分配指定缓冲区大小
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //发送数据给服务端
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请说：");
            String s = sc.nextLine();
            buf.put(("波仔："+s).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
    }
}
