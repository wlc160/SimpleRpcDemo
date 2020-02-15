# SimpleRpcDemo
模拟Dubbo的简单Rpc远程通信框架

客户端：rpc-client

````
说明：客户端以socket远程通信连接方式，与服务端通过网络IO流形式传输调用远程接口，首先会引入服务端发布的服务接口依赖，

再者以socket连接基础上通过ObjectOutputStream发送到服务端和ObjectInputStream获取服务端返回的结果；

其中会应用JDK反向代理实现接口类实例化、传输的对象需实现序列化；
````

服务端：rpc-server

````
说明：服务端以socket远程通信连接，其中分用于发布服务的api子项目和不暴露服务的provider子项目，api项目需要发布到远程仓库

用于provider和客户端依赖；应用ServerSocket和Excutor结合发布一个远程服务给予客户端调用；
````

总体架构：
![Image text](https://github.com/wlc160/img-folder/blob/master/rpcsimple.png)

