package com.example.redisdemo.pattern.single;

/**
 * 懒汉式 （线程不安全）
 */
public class Singleton3 {
    private static Singleton3 instance ;

    private Singleton3(){

    }

    public static Singleton3 getINSTANCE() {
        if(null == instance){
            return instance;
        }
        return new Singleton3();
    }
}
