package com.yxdtyut.grpc.impl;

import com.yxdtyut.grpc.*;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;

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

    @Override
    public StreamObserver<StudentRequest> getStudentListByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("getStudentListByAges receive message: " + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                StudentResponse s1 = StudentResponse.newBuilder().setName("lucky").setAge(2).setCity("西安").build();
                StudentResponse s2 = StudentResponse.newBuilder().setName("happy").setAge(1).setCity("广州").build();
                StudentResponseList list = StudentResponseList.newBuilder().addResponse(s1).addResponse(s2).build();
                responseObserver.onNext(list);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println("biTalk receive message:" + value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(LocalDateTime.now().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
