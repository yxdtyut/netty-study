package com.yxdtyut.grpc.impl;

import com.yxdtyut.grpc.MyRequest;
import com.yxdtyut.grpc.MyResponse;
import com.yxdtyut.grpc.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.logging.Logger;

/**
 * @program: netty_study
 * @description: grpc client
 * @author: yangxudong
 * @create: 2020-05-04 15:02
 **/
public class GrpcClient {
    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext().build();
        final StudentServiceGrpc.StudentServiceBlockingStub stub = StudentServiceGrpc.newBlockingStub(channel);
        final MyResponse response = stub.getRealnameBuUsername(MyRequest.newBuilder().setUsername("libai").build());
        logger.info("response: " + response.getRealname());

    }
}
