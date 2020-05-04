package com.yxdtyut.httpexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @program: netty_study
 * @description: 第一个netty服务端
 * @author: yangxudong
 * @create: 2020-02-29 15:35
 **/
public class HttpServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new Httpinitializer());

            final ChannelFuture channelFuture = server.bind(9999).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
