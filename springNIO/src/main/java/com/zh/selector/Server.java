package com.zh.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author zh
 * @date 2022/6/14 16:06
 * @description:说明: NIO非阻塞通信下的入门案例：服务端开发
 *
 */
public class Server {
    public static void main(String[] args) throws Exception {

        System.out.println("----服务端启动----");
        //获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //配置非阻塞模式
        ssChannel.configureBlocking(false);
        //绑定连接端口
        ssChannel.bind(new InetSocketAddress(9999));
        //获取选择器 Selector
        Selector selector = Selector.open();
        //将通道注册到选择器上并开始监听接收事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        //使用选择器中所注册的通道中已经就绪好的事件
        while (selector.select() > 0){
            System.out.println("---开始一轮事件处理---");
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            //遍历准备好的事件
            while (it.hasNext()){
                SelectionKey sk = it.next();

                //判断具体事件是什么
                if (sk.isAcceptable()){
                    //获取当前接入的客户端通道
                    SocketChannel sChannel = ssChannel.accept();
                    //设置为通道为非阻塞模式
                    sChannel.configureBlocking(false);
                    //将本客户端通道注册到选择器中
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if (sk.isReadable()){
                    //获取当前选择器上的读就绪事件
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    //读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }

                it.remove();//处理完毕需要移除当前事件
            }
        }
    }
}
