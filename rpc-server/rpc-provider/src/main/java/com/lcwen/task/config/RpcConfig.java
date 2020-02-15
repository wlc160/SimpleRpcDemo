package com.lcwen.task.config;

import com.lcwen.task.AutoRpcServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RpcConfig
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/2/15 0015
 **/
@Configuration
@ComponentScan(value =  "com.lcwen.task")
public class RpcConfig {

    @Bean(name = "autoRpcServer")
    public AutoRpcServer autoRpcServer(){
        return  new AutoRpcServer();
    }

}
