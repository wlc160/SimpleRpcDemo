package com.lcwen.task;

import com.lcwen.task.annotation.RpcService;

/**
 * @ClassName ILoginServiceImpl
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/2/15 0015
 **/
@RpcService(value = ILoginService.class)
public class ILoginServiceImpl implements ILoginService {
    @Override
    public String login(String name) {
        System.out.println("用户【" + name + "】登入系统");
        return "欢迎登陆RPC系统";
    }

    @Override
    public void logout(String name) {
        System.out.println("用户【" + name + "】退出系统");
    }
}
