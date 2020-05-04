package com.yxdtyut.grpc.impl;

import com.yxdtyut.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
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
        final StudentServiceGrpc.StudentServiceBlockingStub blockStub = StudentServiceGrpc.newBlockingStub(channel);
        final MyResponse response = blockStub.getRealnameBuUsername(MyRequest.newBuilder().setUsername("libai").build());
        logger.info("response: " + response.getRealname());
        System.out.println("-------------------");

        final Iterator<StudentResponse> studentByAge = blockStub.getStudentByAge(StudentRequest.newBuilder().setAge(26).build());
        while (studentByAge.hasNext()) {
            final StudentResponse studentResponse = studentByAge.next();
            System.out.printf(studentResponse.getName() + "-");
            System.out.printf(studentResponse.getAge() + "-");
            System.out.printf(studentResponse.getCity());
            System.out.println();
        }
        System.out.println("-------------------");

        //只要客户端是以流式的方式发送的请求，一定都是异步的,无法用blockingStub
        final StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(channel);
        final StreamObserver<StudentRequest> streamObserver = stub.getStudentListByAges(new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {
                value.getResponseList().stream().forEach((x) -> {
                    System.out.printf(x.getName() + "-");
                    System.out.printf(x.getAge() + "-");
                    System.out.printf(x.getCity()+"\n");
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("server getStudentListByAges deal onCompleted");
                System.out.println("------------------------------");
            }
        });
        streamObserver.onNext(StudentRequest.newBuilder().setAge(20).build());
        streamObserver.onNext(StudentRequest.newBuilder().setAge(21).build());
        streamObserver.onNext(StudentRequest.newBuilder().setAge(22).build());
        streamObserver.onNext(StudentRequest.newBuilder().setAge(23).build());
        streamObserver.onCompleted();


        final StreamObserver<StreamRequest> streamRequestStreamObserver = stub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("server bitalk deal onCompleted");
            }
        });

        for (int i = 0; i < 10; i++) {
            streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(UUID.randomUUID().toString()).build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        streamRequestStreamObserver.onCompleted();

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
