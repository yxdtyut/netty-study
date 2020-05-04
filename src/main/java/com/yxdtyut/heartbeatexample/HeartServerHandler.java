package com.yxdtyut.heartbeatexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @program: netty_study
 * @description: 心跳服务器处理器
 * @author: yangxudong
 * @create: 2020-03-03 14:27
 **/
public class HeartServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            String type = null;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    type = "读空闲";
                    break;
                case WRITER_IDLE:
                    type = "写空闲";
                    break;
                case ALL_IDLE:
                    type = "读写空闲";
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件:" + type);
            ctx.channel().close();
        }
    }
}
