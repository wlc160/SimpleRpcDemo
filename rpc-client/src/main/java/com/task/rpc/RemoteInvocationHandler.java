package com.task.rpc;

import com.lcwen.task.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @ClassName RemoteInvocationHandler
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/2/14 0014
 **/
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host ,int port){
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest(method.getDeclaringClass().getName(),
                method.getName(),args);
        RpcNetTransport transport = new RpcNetTransport(host,port);
        Object result = transport.send(request);
        return result;
    }
}
