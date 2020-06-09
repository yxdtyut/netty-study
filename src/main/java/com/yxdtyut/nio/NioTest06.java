package com.yxdtyut.nio;

import java.nio.ByteBuffer;

/**
 * @program: netty_study
 * @description: buffer基本类型操作
 * @author: yangxudong
 * @create: 2020-05-27 07:13
 **/
public class NioTest06 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.putInt(10);
        buffer.putLong(12L);
        buffer.putDouble(12.333);
        buffer.putChar('哈');
        buffer.putShort((short) 1);
        buffer.flip();
        System.out.println("===");
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}
