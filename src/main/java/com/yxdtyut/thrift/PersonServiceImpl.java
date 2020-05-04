package com.yxdtyut.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @program: netty_study
 * @description: 服务端接口实现类
 * @author: yangxudong
 * @create: 2020-03-14 20:32
 **/
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("通过用户名" + username + "获取用户信息");
        final Person person = new Person();
        person.setUsername(username);
        person.setAge(12);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("保存用户信息");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
