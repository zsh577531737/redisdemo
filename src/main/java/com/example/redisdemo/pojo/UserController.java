package com.example.redisdemo.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Log(operationType="add操作:",operationName="添加用户")
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @Test
    public void testAOP1(){
        //启动Spring容器
        //获取service或controller组件
        new  UserController().test();
    }
}
