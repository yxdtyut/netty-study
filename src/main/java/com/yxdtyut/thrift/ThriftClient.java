package com.yxdtyut.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @program: netty_study
 * @description: thrift客户端
 * @author: yangxudong
 * @create: 2020-03-14 20:44
 **/
public class ThriftClient {
    public static void main(String[] args) {
        final TFramedTransport transport = new TFramedTransport(new TSocket("localhost", 9999), 600);
        final TCompactProtocol protocol = new TCompactProtocol(transport);
        final PersonService.Client client = new PersonService.Client(protocol);
        try {
            transport.open();

            final Person person = client.getPersonByUsername("杜甫");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            final Person person1 = new Person();
            person1.setUsername("消炎");
            person1.setAge(18);
            person1.setMarried(true);
            client.savePerson(person1);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }
    }
}
