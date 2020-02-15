package com.lcwen.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

public class AutoProcessorHandler implements Runnable{

    private Socket socket;
    private Map<String,Object> handlerMap;

    public AutoProcessorHandler(Socket socket, Map<String,Object> handlerMap) {
        this.socket = socket;
        this.handlerMap = handlerMap;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            ois = new ObjectInputStream(socket.getInputStream());
            RpcRequest request = (RpcRequest)ois.readObject();
            Object result = invoke(request);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ois != null) {
                   ois.close();
                }
                if (oos != null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String className = request.getClassName();
        Object service = handlerMap.get(className);
        if (service == null){
            throw new RuntimeException("service not found " + className);
        }
        Object[] args = request.getParameters();
        Class clazz = Class.forName(className);
        Method method = null;
        Object result = null;
        if (args != null){
            Class<?>[] types = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                types[i] = args[i].getClass();
            }
            method = clazz.getMethod(request.getMethodName(),types);
            result =  method.invoke(service,args);
        }else{
            method = clazz.getMethod(request.getMethodName());
            result =  method.invoke(service);
        }
        return result;
    }

}
