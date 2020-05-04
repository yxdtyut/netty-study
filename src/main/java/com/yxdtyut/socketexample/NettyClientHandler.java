package com.yxdtyut.socketexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @program: netty_study
 * @description: netty client 处理器
 * @author: yangxudong
 * @create: 2020-03-01 20:40
 **/
public class NettyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("从服务端：" + ctx.channel().remoteAddress() + "接收到信息：" + msg);
        ctx.writeAndFlush("client receive time:" + LocalDateTime.now());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("发送一个msg");
    }
}
