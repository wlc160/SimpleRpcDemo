package com.lcwen.task;

/**
 * @ClassName ILoginService
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/2/15 0015
 **/
public interface ILoginService {

    String login(String name);

    //登出--假设无返回值
    void logout(String name);

}
