package com.yxdtyut.grpc.impl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @program: netty_study
 * @description: grpc server
 * @author: yangxudong
 * @create: 2020-05-04 14:52
 **/
public class GrpcServer {

    private final static Logger logger = Logger.getLogger(GrpcServer.class.getName());

    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(8899)
                .addService(new StudentServiceImpl())
                .build().start();
        logger.info("grpc server started");

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            logger.info("shutting down gRPC server since JVM is shutting down");
            try {
                stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("grpc server shutdown");
        }));
    }

    private void stop () throws InterruptedException {
        if (null != server) {
            server.shutdown().awaitTermination(3000, TimeUnit.MICROSECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (null != server) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }

}
