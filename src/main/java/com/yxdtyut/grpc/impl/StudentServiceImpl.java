package com.yxdtyut.grpc.impl;

import com.yxdtyut.grpc.MyRequest;
import com.yxdtyut.grpc.MyResponse;
import com.yxdtyut.grpc.StudentServiceGrpc;
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
}
