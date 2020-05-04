package com.yxdtyut.protobufexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @program: netty_study
 * @description: protobuf服务端自定义处理器
 * @author: yangxudong
 * @create: 2020-03-13 09:44
 **/
public class ProServerHandler extends SimpleChannelInboundHandler<Person.OutMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Person.OutMessage msg) throws Exception {
        final Person.OutMessage.PersonType type = msg.getType();
        if (type == Person.OutMessage.PersonType.StudentType) {
            final Person.Student student = msg.getStudent();
            System.out.println(student.getName());
            System.out.println(student.getAddress());
            System.out.println(student.getAge());
        } else if (type == Person.OutMessage.PersonType.TeacherType) {
            final Person.Teacher teacher = msg.getTeacher();
            System.out.println(teacher.getName());
            System.out.println(teacher.getAge());
        } else if (type == Person.OutMessage.PersonType.DoctorType) {
            final Person.Doctor doctor = msg.getDoctor();
            System.out.println(doctor.getName());
            System.out.println(doctor.getAge());
            System.out.println(doctor.getSex());
        }
    }
}
