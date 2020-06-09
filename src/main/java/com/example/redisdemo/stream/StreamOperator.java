package com.example.redisdemo.stream;

import com.alibaba.fastjson.JSON;
import com.example.redisdemo.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamOperator {

    List<User> list = new ArrayList<>();
    @Before
    public void init(){
        User user1 = new User("张三",12);
        User user2 = new User("李四",15);
        User user3 = new User("王二",17);
        User user4 = new User("麻子",12);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
    }

    @Test
    public void test(){
        list.stream().filter(user ->
                             user.getAge() == 12)
                     .forEach(item -> System.out.println(JSON.toJSONString(item,true)));
    }

    /**
     * map：将一个元素转换成另一个元素
     */
    @Test
    public void test2(){
        list.stream().map(user -> user.getAge())
                .forEach(item -> System.out.println(JSON.toJSONString(item,true)));
    }

    /**
     * filtMap:将一个对象转换成流
     */
    @Test
    public void test3(){
        list.stream().flatMap(user -> Arrays.stream(user.getName().split("")))
                .forEach(item -> System.out.println(JSON.toJSONString(item,true)));
    }

    /**
     * peak:
     */
    @Test
    public void test4(){
        list.stream()
                .peek(user -> System.out.println(user.getAge()))
                .forEach(item -> System.out.println(JSON.toJSONString(item,true)));
    }

    @Test
    public void test5(){
        list.stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(item -> System.out.println(JSON.toJSONString(item)));
    }



}
