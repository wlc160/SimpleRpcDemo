package com.lcwen.task;

import com.lcwen.task.config.RpcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //第一种方式：单一的实现暴露单个接口和远程调用 - 比较不当便
        /*IHelloService helloService = new IHelloServiceImpl();
        RpcProxyServer server = new RpcProxyServer();
        server.publisher(helloService,8080);*/

        //第二种方式：通过注解的形式去实现
        ApplicationContext context = new AnnotationConfigApplicationContext(RpcConfig.class);
        ((AnnotationConfigApplicationContext)context).start();
    }
}
