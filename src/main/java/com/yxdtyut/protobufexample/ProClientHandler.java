package com.yxdtyut.protobufexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @program: netty_study
 * @description: protobuf客户端处理器
 * @author: yangxudong
 * @create: 2020-03-13 09:53
 **/
public class ProClientHandler extends SimpleChannelInboundHandler<Person.OutMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Person.OutMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int num = new Random().nextInt(3);
        Person.OutMessage outMessage = null;
        if (0 == num) {
            outMessage = Person.OutMessage.newBuilder()
                    .setType(Person.OutMessage.PersonType.StudentType)
                    .setStudent(Person.Student.newBuilder().setName("李白").setAge(12).setAddress("唐朝").build())
                    .build();
        } else if (1 == num) {
            outMessage = Person.OutMessage.newBuilder()
                    .setType(Person.OutMessage.PersonType.TeacherType)
                    .setTeacher(Person.Teacher.newBuilder().setName("鲁迅").setAge(23).build())
                    .build();
        } else {
            outMessage = Person.OutMessage.newBuilder()
                    .setType(Person.OutMessage.PersonType.DoctorType)
                    .setDoctor(Person.Doctor.newBuilder().setName("白求恩").setAge(39).setSex("男").build())
                    .build();
        }
        ctx.writeAndFlush(outMessage);
    }
}
