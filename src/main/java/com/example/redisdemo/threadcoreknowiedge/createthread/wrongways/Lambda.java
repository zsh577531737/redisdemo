package com.example.redisdemo.threadcoreknowiedge.createthread.wrongways;

/**
 * 错误案例：使用lamda表达式实现线程
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
