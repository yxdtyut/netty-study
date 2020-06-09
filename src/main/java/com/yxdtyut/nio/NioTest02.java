package com.yxdtyut.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: netty_study
 * @description: byte字节，代表范围-128~127 char字符，2个字节 0~65535,不能表示负数
 *              中文，英文都可以用char表示出来，用byte就显示成对应数字了，中文用byte必须强转
 * @author: yangxudong
 * @create: 2020-05-17 21:26
 **/
public class NioTest02 {
    private ByteBuffer buffer;

    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream("nioFile2.txt");
        final FileChannel channel = inputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            char c = (char)buffer.get();
            System.out.println(c);
        }
        inputStream.close();
    }
}
