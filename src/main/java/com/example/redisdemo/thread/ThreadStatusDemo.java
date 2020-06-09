package com.example.redisdemo.thread;

import java.util.concurrent.TimeUnit;

public class ThreadStatusDemo {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"timewaitting").start();
    }
}
