package com.task.rpc;

import com.lcwen.task.IHelloService;
import com.lcwen.task.ILoginService;
import com.lcwen.task.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User user = new User();
        user.setName("wlc");
        user.setAge(18);

        RpcProxyClient client = new RpcProxyClient();
        /*IHelloService helloService = client.clientProxy(
                IHelloService.class, "localhost", 8080);
        System.out.println(helloService.sayHello("lcwen"));
        System.out.println(helloService.saveUser(user));*/


        ILoginService loginService = client.clientProxy(ILoginService.class, "localhost", 8080);
        System.out.println(loginService.login("lcwen"));
        loginService.logout("lcwen");
    }
}
