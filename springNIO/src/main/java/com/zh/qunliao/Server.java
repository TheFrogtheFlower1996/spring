package com.zh.qunliao;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author zh
 * @date 2022/6/14 21:48
 * @description:说明 服务端群聊实现
 */
public class Server {

        //定义成员属性：选择器、服务器通道、端口
        private Selector selector;
        private ServerSocketChannel ssChannel;
        private static final int PORT = 9999;

        //构造器 定义初始化逻辑
        public Server(){
            try {
                //创建选择器对象
                selector = Selector.open();
                //创建通道对象
                ssChannel = ServerSocketChannel.open();
                //开启通道非阻塞模式
                ssChannel.configureBlocking(false);
                //通道绑定监听客户端端口
                ssChannel.bind(new InetSocketAddress(PORT));
                //把通道注册到选择器上，并且指定 "监听接收事件"
                ssChannel.register(selector, SelectionKey.OP_ACCEPT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**
         * 开始监听
         * */
        private void listen() {
            try {
                while (selector.select() > 0){
                    //获取选择器中所有就绪事件
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    //遍历事件
                    while (it.hasNext()){
                        //获取事件
                        SelectionKey sk = it.next();
                        //判断事件类型
                        if (sk.isAcceptable()){
                            //客户端接入请求
                            //获取当前客户端通道
                            SocketChannel schannel = ssChannel.accept();
                            //也注册成非阻塞模式
                            schannel.configureBlocking(false);
                            //注册给选择器，监听读事件
                            schannel.register(selector,SelectionKey.OP_READ);
                        }else if (sk.isReadable()){
                            //处理客户端消息，接收并实现转发
                            readClientData(sk);

                        }
                        it.remove();//处理完后需要移除当前事件

                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        /**
         * 接收当前客户通道信息，转发给其他全部客户端通道
         * */
        private void readClientData(SelectionKey sk) {
            SocketChannel sChannel = null;
            try {
                //直接得到当前客户端通道
                sChannel = (SocketChannel) sk.channel();
                //创建缓冲区对象 接收客户端通道数据
                ByteBuffer buf = ByteBuffer.allocate(1024);
                int count = sChannel.read(buf);
                if (count > 0){
                    buf.flip();
                    //提取读取的数据
                    String msg = new String(buf.array(), 0, buf.remaining());
                    System.out.println("接收到了客户端消息："+msg);
                    //把这个消息推送给全部客户端接收
                    sendMsgToAllClient(msg,sChannel);

                }

            }catch (Exception e){
                try {
                    System.out.println("有人离线了："+sChannel.getRemoteAddress());
                    //当前客户端离线
                    sk.channel();//取消注册
                    sChannel.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }
        /**
         * 把当前客户端的消息数据推送给当前全部在线注册的channel通道
         * */
        private void sendMsgToAllClient(String msg, SocketChannel sChannel) throws IOException {
            System.out.println("服务端开始转发消息，当前线程："+ Thread.currentThread().getName());
            for (SelectionKey key : selector.keys()) {
                Channel channel = key.channel();
                //不能把信息发送给自己
                if (channel instanceof SocketChannel && channel != sChannel){
                    ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                    ((SocketChannel)channel).write(buffer);
                }
            }
        }

    public static void main(String[] args) {
            //创建服务端对象
            Server server = new Server();
            //开始监听客户端的各种消息事件：连接、群聊消息、离线消息
            server.listen();
        }



}
