package com.yxdtyut.grpc.impl;

import com.yxdtyut.grpc.*;
import io.grpc.stub.StreamObserver;

/**
 * @program: netty_study
 * @description: 基于studentService grpc接口的实现类
 * @author: yangxudong
 * @create: 2020-05-04 14:50
 **/
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealnameBuUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接受到请求:" + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("李白").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("getStudentByAge 客户端请求信息：" + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("李四").setAge(21).setCity("上海").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("王五").setAge(22).setCity("广州").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("赵六").setAge(23).setCity("深圳").build());
        responseObserver.onCompleted();
    }
}
