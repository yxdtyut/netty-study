package com.yxdtyut.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @program: netty_study
 * @description:
 * @author: yangxudong
 * @create: 2020-05-17 21:19
 **/
public class NioTest01 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            int random = new SecureRandom().nextInt(20);
            intBuffer.put(random);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
