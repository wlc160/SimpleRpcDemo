package com.lcwen.task.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //->类或借口
@Retention(RetentionPolicy.RUNTIME)//运行时
@Component //被spring扫描解析
public @interface RpcService {

    Class<?> value();//拿到服务的接口
}
