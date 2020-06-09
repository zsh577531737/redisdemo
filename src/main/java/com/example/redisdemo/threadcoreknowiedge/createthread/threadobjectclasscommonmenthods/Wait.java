package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

/**
 * 使用notify唤醒wait中的线程
 */
public class Wait {
    private static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+":进入thread1同步块");
                    try {
                        object.wait();
                        System.out.println(Thread.currentThread().getName()+":thread1执行完毕");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (object){
                    System.out.println("thread2进入");
                    object.notify();
                    System.out.println("thread2结束");
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }



}
