package com.yxdtyut.chatexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @program: netty_study
 * @description: 聊天客户端
 * @author: yangxudong
 * @create: 2020-03-02 22:59
 **/
public class ChatClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());
            final ChannelFuture channelfuture = bootstrap.connect("localhost", 8888).sync();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                channelfuture.channel().writeAndFlush(br.readLine() + "\r\n");
            }
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
