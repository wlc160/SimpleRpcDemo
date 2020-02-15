package com.lcwen.task;

import java.io.Serializable;

/**
 * @ClassName RpcRequest
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/2/14 0014
 **/
public class RpcRequest implements Serializable {

    private String className;
    private String methodName;
    private Object[] parameters;

    public RpcRequest(){

    }

    public RpcRequest(String className, String methodName, Object[] parameters) {
        this.className = className;
        this.methodName = methodName;
        this.parameters = parameters;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
