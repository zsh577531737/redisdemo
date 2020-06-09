package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程sleep期间不释放lock锁
 */
public class SleepWaitNotReleaseLock implements Runnable{
    private static final Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        System.out.println("线程"+Thread.currentThread().getName()+"进入");
        try {
            Thread.sleep(5000);
            System.out.println("线程"+Thread.currentThread().getName()+"结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SleepWaitNotReleaseLock sleepWaitNotReleaseLock = new SleepWaitNotReleaseLock();
        Thread thread = new Thread(sleepWaitNotReleaseLock);
        Thread thread2 = new Thread(sleepWaitNotReleaseLock);
        thread.start();
        thread2.start();
    }
}
