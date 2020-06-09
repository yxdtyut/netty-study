package com.yxdtyut.nio;

import java.nio.IntBuffer;

/**
 * @program: netty_study
 * @description:
 * @author: yangxudong
 * @create: 2020-05-17 22:20
 **/
public class NioTest04 {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(6);
        buffer.put(1);
        buffer.put(2);
        buffer.put(3);
        buffer.put(4);
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println("===");
        buffer.flip();
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println("===");
        System.out.println(buffer.get());
        System.out.println(buffer.get());
        buffer.flip();
        System.out.println("===");
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        buffer.put(5);
        buffer.put(6);
        System.out.println("===");
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
//        System.out.println("===");
//        System.out.println(buffer.limit());
//        System.out.println(buffer.position());
    }
}
