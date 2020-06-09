package com.example.redisdemo.threadcoreknowiedge.createthread.threaderror;

public class MultiThreadErrorOfLock implements Runnable{
    private static  Object object1 = new Object();
    private static  Object object2 = new Object();
    int flag =0;
    @Override
    public void run() {
        if(flag == 0) {
            System.out.println(Thread.currentThread().getName() + "等待锁1");
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + "获取第锁1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "等待锁2");
                synchronized (object2) {
                    System.out.println(Thread.currentThread().getName() + "获取锁2");
                }
            }
        }
            if(flag == 1){
            synchronized (object2){
                System.out.println(Thread.currentThread().getName()+"获取第锁1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"等待锁1");
                synchronized (object1){
                    System.out.println(Thread.currentThread().getName()+"获取锁1");
                }
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadErrorOfLock runnable1 = new MultiThreadErrorOfLock();
        MultiThreadErrorOfLock runnable2 = new MultiThreadErrorOfLock();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        runnable1.flag =1;
        runnable2.flag =0;
        thread1.start();
        thread2.start();



    }
}
