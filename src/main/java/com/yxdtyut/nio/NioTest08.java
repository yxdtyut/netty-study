package com.yxdtyut.nio;

import java.nio.ByteBuffer;

/**
 * @program: netty_study
 * @description: readOnlyBuffer
 * @author: yangxudong
 * @create: 2020-05-27 07:23
 **/
public class NioTest08 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(12);
        System.out.println(buffer.getClass());
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }
        final ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        readOnlyBuffer.put(0, (byte) 1);
    }
}
