package com.example.redisdemo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void method(){
        System.out.println("学生名字为：" + name);
        System.out.println("学生年龄为：" + age);
    }

}
