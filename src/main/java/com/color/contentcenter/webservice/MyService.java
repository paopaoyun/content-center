package com.color.contentcenter.webservice;

import javax.jws.WebService;
import java.util.List;

@WebService(name = "MyService", // 暴露服务名称
        targetNamespace = "http://service.contentcenter.color.com"// 命名空间,一般是接口的包名倒序
)
public interface MyService {

    String sayHello(String msg,Company company);

    List<User> getUsers();

}