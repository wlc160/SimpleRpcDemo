package com.task.rpc;

import java.lang.reflect.Proxy;

/**
 * 代理类
 * @ClassName RpcProxyClient
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/2/14 0014
 **/
public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls ,final String host ,final int port){
        return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class[]{interfaceCls},new RemoteInvocationHandler(host,port));
    }

}
