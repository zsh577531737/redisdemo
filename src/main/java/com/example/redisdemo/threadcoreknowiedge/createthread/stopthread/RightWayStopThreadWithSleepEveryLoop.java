package com.example.redisdemo.threadcoreknowiedge.createthread.stopthread;

/**
 *
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            int num = 0;
            try {
                while (num <= 10000 && !Thread.currentThread().isInterrupted()){
                    if(num % 100 == 0){
                        System.out.println(num+"是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        try {
            thread.start();
            thread.sleep(5000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
