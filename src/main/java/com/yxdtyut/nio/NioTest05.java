package com.yxdtyut.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: netty_study
 * @description:
 * @author: yangxudong
 * @create: 2020-05-25 07:59
 **/
public class NioTest05 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        final FileChannel inputStreamChannel = inputStream.getChannel();
        final FileChannel outputStreamChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(30);

        while (true) {
            buffer.clear();
            final int read = inputStreamChannel.read(buffer);
            System.out.println("read finish buffer position:" + buffer.position() + ",limit:" + buffer.limit());
            System.out.println("read:" + read);
            if (read == -1) {
                break;
            }
            buffer.flip();
            outputStreamChannel.write(buffer);
            System.out.println("write finish buffer position:" + buffer.position() + ",limit:" + buffer.limit());
        }
    }
}
