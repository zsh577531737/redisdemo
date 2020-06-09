package com.example.redisdemo.threadcoreknowiedge.createthread.stopthread;

/**
 * run 方法没有sleep或wait方法时，停止线程
 */
public class RightWayStopThreadWithoutSleep implements Runnable{
    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num < Integer.MAX_VALUE/2){
            if (num % 10000 == 0){
                System.out.println(num+"是一万倍数");
            }
            num++;
        }
        System.out.println("任务完成");
    }

    public static void main(String[] args) {
       Thread thread =  new Thread(new RightWayStopThreadWithoutSleep());
       thread.start();
        try {
            Thread.sleep(2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
