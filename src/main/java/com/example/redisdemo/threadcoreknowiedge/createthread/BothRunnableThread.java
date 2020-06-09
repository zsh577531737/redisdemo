package com.example.redisdemo.threadcoreknowiedge.createthread;

/**
 * 同时使用runnable和runnbale
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是runnble");
            }
        }){
            @Override
            public void run() {
                System.out.println("我是thread");
            }
        }.start();
    }
}
