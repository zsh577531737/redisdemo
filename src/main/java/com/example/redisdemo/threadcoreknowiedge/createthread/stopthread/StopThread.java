package com.example.redisdemo.threadcoreknowiedge.createthread.stopthread;

/**
 * 使用stop停止线程，
 */
public class StopThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            System.out.println("联队"+i+"开始领取");
            for (int j = 0; j <10 ; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("联队"+i+"领取结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
       Thread thread = new Thread(new StopThread());
       thread.start();
       Thread.sleep(800);
       thread.stop();


    }
}
