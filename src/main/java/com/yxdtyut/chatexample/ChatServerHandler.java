package com.yxdtyut.chatexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @program: netty_study
 * @description: 聊天服务端处理类
 * @author: yangxudong
 * @create: 2020-03-02 22:50
 **/
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channels.forEach(ch -> {
            if (ch != channel) {
                ch.writeAndFlush(channel.remoteAddress() + "发送消息:" + msg +"\n");
            } else {
                ch.writeAndFlush("[自己]:" + msg +"\n");
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        final Channel channel = ctx.channel();
        channels.writeAndFlush(channel.remoteAddress() + "连接到服务器");
        channels.add(channel);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "下线\n");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channels.writeAndFlush(ctx.channel().remoteAddress() + "从服务器断开连接\n");
        //这里netty会帮我们自动调用channels.remove();方法
        System.out.println(channels.size());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
