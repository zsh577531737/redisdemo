package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                    System.out.println(Thread.currentThread().getName()+":进入thread1同步块");
                }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
//        thread1.join();
        //等同上面
        synchronized (thread1){
            thread1.wait();
        }
        System.out.println("结束");
    }
}
