package com.lcwen.task;

import com.lcwen.task.annotation.RpcService;

@RpcService(value = IHelloService.class)
public class IHelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("request in " + name);
        return "Hello," + name;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("request in saveUser" + user);
        return "SUCCESS";
    }
}
