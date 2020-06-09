package com.example.redisdemo.threadcoreknowiedge.createthread.stopthread;

/**
 * 带有sleep的中断线程写法
 */
public class RightWayStopThreadWithSleep {
    public static void main(String[] args) {
        Runnable runnable = ()->{
          int num = 0;
          try {
              while (num <= 3000  && !Thread.currentThread().isInterrupted()){
                  if(num % 100 == 0){
                      System.out.println(num+"是100的倍数");
                  }
                  num++;
              }
               Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        try {
            thread.start();
            thread.sleep(500);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
