package com.example.redisdemo.pattern.single;

/**
 * 懒汉式，线程不安全，不推荐
 */
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5(){

    }

    public static Singleton5 getInstance() {
        if(null == instance){
            synchronized (Singleton5.class){
                return new Singleton5();
            }
        }
        return instance;

    }
}
