package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

/**
 * join基本用法
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕1");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        });
        System.out.println("主线程开始执行");
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("主线程执行完毕");
    }

}
