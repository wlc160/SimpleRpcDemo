package com.lcwen.task;

import com.lcwen.task.annotation.RpcService;
import com.lcwen.task.constant.PortConstant;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName AutoRpcServer
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/2/15 0015
 **/
@Component
public class AutoRpcServer implements ApplicationContextAware, InitializingBean {

    ExecutorService execServ = Executors.newCachedThreadPool();
    Map<String,Object> handlerMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PortConstant.SOCKET_PORT);

            while(true){
                Socket socket = serverSocket.accept();
                execServ.execute(new AutoProcessorHandler(socket,handlerMap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (!serviceBeanMap.isEmpty()){
            for (Object serviceBean : serviceBeanMap.values()) {
                RpcService service = serviceBean.getClass().getAnnotation(RpcService.class);
                String serviceName = service.value().getName();
                handlerMap.put(serviceName,serviceBean);
            }
        }
    }
}
