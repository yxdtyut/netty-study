package com.yxdtyut.nio;

import com.yxdtyut.protobuf.ProtobufTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: netty_study
 * @description:
 * @author: yangxudong
 * @create: 2020-06-06 08:36
 **/
public class NioClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            selector.select();
            final Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                if (selectionKey.isConnectable()) {
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    if (client.isConnectionPending()) {
                        try {
                            client.finishConnect();
                            buffer.put((LocalDateTime.now() + "连接成功").getBytes());
                            buffer.flip();
                            client.write(buffer);
                            ExecutorService executorService = Executors.newSingleThreadExecutor();
                            executorService.submit(() -> {
                                while (true) {
                                    buffer.clear();
                                    InputStreamReader inputStream = new InputStreamReader(System.in);
                                    BufferedReader bufferedReader = new BufferedReader(inputStream);
                                    String message = bufferedReader.readLine();
                                    buffer.put(message.getBytes());
                                    buffer.flip();
                                    client.write(buffer);
                                }
                            });
                            client.register(selector, SelectionKey.OP_READ);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (selectionKey.isReadable()) {
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    buffer.clear();
                    try {
                        client.read(buffer);
                        buffer.flip();
                        Charset charset = Charset.forName("UTF-8");
                        System.out.println("收到:" + charset.decode(buffer));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            selectionKeys.clear();
        }
    }

}
