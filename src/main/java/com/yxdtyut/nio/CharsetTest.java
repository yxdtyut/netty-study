package com.yxdtyut.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @program: netty_study
 * @description:
 * @author: yangxudong
 * @create: 2020-06-06 12:32
 **/
public class CharsetTest {
    public static void main(String[] args) throws Exception{
        String inputFile = "charsetInput.txt";
        String outputFile = "charsetOutput.txt";
        RandomAccessFile inputRandom = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandom = new RandomAccessFile(outputFile, "rw");

        long inputLength = new File(inputFile).length();

        final FileChannel inputRandomChannel = inputRandom.getChannel();
        final FileChannel outputRandomChannel = outputRandom.getChannel();

        MappedByteBuffer buffer = inputRandomChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);

        Charset charset = Charset.forName("utf-8");
        //解码，将文件内容（字符或者字符串）转成ByteBuffer
        final CharsetDecoder charsetDecoder = charset.newDecoder();
        //编码，将ByteBuffer转成字符或者字符串
        final CharsetEncoder charsetEncoder = charset.newEncoder();

        final CharBuffer decode = charsetDecoder.decode(buffer);
        final ByteBuffer encode = charsetEncoder.encode(decode);

        outputRandomChannel.write(encode);

        inputRandomChannel.close();
        outputRandomChannel.close();
    }
}
