package com.example.redisdemo.threadcoreknowiedge.createthread.stopthread;

public class CantInterrupt {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000){
                if (num % 100 == 0){
                    System.out.println(num+"是100倍数");
                }
                num++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        try {
            thread.start();
            thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
