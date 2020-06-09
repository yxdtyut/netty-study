package com.yxdtyut.nio;

import java.nio.ByteBuffer;

/**
 * @program: netty_study
 * @description: buffer slice
 * @author: yangxudong
 * @create: 2020-05-27 07:18
 **/
public class NioTest07 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(12);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }
        buffer.position(2);
        buffer.limit(6);
        final ByteBuffer sliceBuffer = buffer.slice();
        while (sliceBuffer.hasRemaining()) {
            System.out.println(sliceBuffer.get());
        }
        System.out.println("==========");
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
