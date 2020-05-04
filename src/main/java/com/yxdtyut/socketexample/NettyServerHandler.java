package com.yxdtyut.socketexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @program: netty_study
 * @description: netty 服务端 处理器
 * @author: yangxudong
 * @create: 2020-03-01 20:29
 **/
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("从客户端:" + ctx.channel().remoteAddress() + "收到信息：" + msg);
        ctx.writeAndFlush(String.valueOf(msg.length()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
