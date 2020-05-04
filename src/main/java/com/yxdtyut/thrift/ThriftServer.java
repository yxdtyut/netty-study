package com.yxdtyut.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import thrift.generated.PersonService;

/**
 * @program: netty_study
 * @description: thrift服务端
 * @author: yangxudong
 * @create: 2020-03-14 20:38
 **/
public class ThriftServer {
    public static void main(String[] args) throws Exception {
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(9999);
        final THsHaServer.Args arg = new THsHaServer.Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(4);
        final PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

        final THsHaServer server = new THsHaServer(arg);
        System.out.println("thrift server start");
        server.serve();
    }
}
