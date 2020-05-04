package com.yxdtyut.heartbeatexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @program: netty_study
 * @description: 心跳服务端初始化器
 * @author: yangxudong
 * @create: 2020-03-03 10:49
 **/
public class HeartServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(5, 7, 9, TimeUnit.SECONDS));
        pipeline.addLast(new HeartServerHandler());
    }
}
