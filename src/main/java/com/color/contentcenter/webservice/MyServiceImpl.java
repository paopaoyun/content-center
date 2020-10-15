package com.color.contentcenter.webservice;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "MyService", // 与接口中指定的服务name一致
        targetNamespace = "http://service.contentcenter.color.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.color.contentcenter.webservice.MyService"// 接口地址
)
public class MyServiceImpl implements MyService {
 
    @Override
    public String sayHello(String msg, Company company) {
        return "收到的信息是:--->" + msg + ",现在时间是:--->" + new Date();
    }
 
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "一一哥", "北京"));
        users.add(new User(2L, "一一哥", "上海"));
        return users;
    }
 
}