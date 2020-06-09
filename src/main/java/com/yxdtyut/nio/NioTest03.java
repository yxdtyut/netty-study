package com.yxdtyut.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: netty_study
 * @description:
 * @author: yangxudong
 * @create: 2020-05-17 21:32
 **/
public class NioTest03 {
    public static void main(String[] args) throws Exception{
        FileOutputStream outputStream = new FileOutputStream("nioFile3.txt");
        final FileChannel channel = outputStream.getChannel();
        byte[] message = "hello nio 3".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        for (int i = 0; i < message.length; i++) {
            buffer.put(message[i]);
        }
        buffer.flip();
        channel.write(buffer);
        outputStream.close();
    }
}
