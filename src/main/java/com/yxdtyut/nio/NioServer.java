package com.yxdtyut.nio;

import com.google.common.primitives.Chars;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @program: netty_study
 * @description:
 * @author: yangxudong
 * @create: 2020-06-06 08:04
 **/
public class NioServer {
    public static void main(String[] args) throws Exception{
        Map<String, SocketChannel> clientMap = new HashMap<>();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        final ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            final Set<SelectionKey> selectionKeys = selector.selectedKeys();
            final Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                final SelectionKey selectionKey = iterator.next();
                SocketChannel client = null;
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel socketChannel = (ServerSocketChannel) selectionKey.channel();
                    client = socketChannel.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    clientMap.put(UUID.randomUUID().toString(), client);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    buffer.flip();
                    Charset charset = Charset.forName("UTF-8");
                    String key = findSocketChannelKey(socketChannel, clientMap);
                    String response = "客户端" +key+ "发来请求:" + charset.decode(buffer);
                    System.out.println(response);
                    buffer.clear();
                    buffer.put(response.getBytes());
                    buffer.flip();
                    clientMap.forEach((x,y) -> {
                        if (y != socketChannel) {
                            try {
                                y.write(buffer);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                iterator.remove();
            }
        }
    }

    private static String findSocketChannelKey(SocketChannel socketChannel, Map<String, SocketChannel> clientMap) {
        Set<Map.Entry<String, SocketChannel>> clientSet = clientMap.entrySet();
        for (Map.Entry<String, SocketChannel> client : clientSet) {
            if (client.getValue() == socketChannel) {
                return client.getKey();
            }
        }
        return null;
    }
}
