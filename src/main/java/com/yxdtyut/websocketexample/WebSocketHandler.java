package com.yxdtyut.websocketexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.time.LocalDateTime;

/**
 * @program: netty_study
 * @description: 处理器
 * @author: yangxudong
 * @create: 2020-03-07 20:53
 **/
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("接收到数据:" + msg.text());
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间:" + LocalDateTime.now()));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().id().asLongText() + "建立连接");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().id().asLongText() + "断开连接");
    }
}
