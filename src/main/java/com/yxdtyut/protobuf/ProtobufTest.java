package com.yxdtyut.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @program: netty_study
 * @description: 测试protobuf
 * @author: yangxudong
 * @create: 2020-03-08 17:30
 **/
public class ProtobufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("李白").setAge(23).setAddress("唐朝").build();
        final byte[] bytes = student.toByteArray();

        final DataInfo.Student student2 = DataInfo.Student.parseFrom(bytes);
        System.out.println(student2.toString());

        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getAddress());
    }
}
