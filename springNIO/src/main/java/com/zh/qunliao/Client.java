package com.zh.qunliao;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author zh
 * @date 2022/6/15 9:45
 * @description:说明 群聊客户端逻辑
 */
public class Client {

    //客户端属性
    private Selector selector;
    private SocketChannel sChannel;
    private static int PORT = 9999;

    //初始化客户端信息
    public Client(){
        try {
            //创建选择器
            selector = Selector.open();
            //创建通道，链接服务端
            sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",PORT));
            //设置通道为非阻塞模式
            sChannel.configureBlocking(false);
            //选择器监听读事件
            sChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("---客户端准备完成---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        //定义一个线程专门负责监听服务端发送过来的读消息事件
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client.readInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String msg = sc.nextLine();
            client.sendMsgToServer(msg);
        }

    }

    private void sendMsgToServer(String msg) {
        try {
            sChannel.write(ByteBuffer.wrap(("波妞说："+msg).getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readInfo() throws IOException {
        while (selector.select() > 0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isReadable()){
                    SocketChannel sc = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    sc.read(buffer);
                    System.out.println(new String(buffer.array()));
                }
            }
            iterator.remove();
        }
    }
}
