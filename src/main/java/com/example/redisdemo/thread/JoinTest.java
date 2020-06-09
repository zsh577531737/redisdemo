package com.example.redisdemo.thread;

public class JoinTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<30;i++){
                    System.out.println("子线程i="+i);
                }
            }
        });
        t1.start();
        for(int i=0;i<30;i++){
            System.out.println("主线程i="+i);
        }
    }
}
