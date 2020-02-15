package com.lcwen.task;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {

    ExecutorService execServ = Executors.newCachedThreadPool();

    public void publisher(Object service ,int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);

            while(true){
                Socket socket = serverSocket.accept();
                execServ.execute(new ProcessorHandler(socket,service));
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

}
