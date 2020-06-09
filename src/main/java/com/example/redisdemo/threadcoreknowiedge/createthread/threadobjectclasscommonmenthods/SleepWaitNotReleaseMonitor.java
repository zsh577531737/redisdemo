package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

/**
 * 线程sleep期间不释放minitor锁
 */
public class SleepWaitNotReleaseMonitor implements Runnable{
    private static Object object = new Object();
    @Override
    public void run() {
        synchronized (object){
            System.out.println("线程"+Thread.currentThread().getName()+"进入");
            try {
                Thread.sleep(5000);
                System.out.println("线程"+Thread.currentThread().getName()+"结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SleepWaitNotReleaseMonitor sleepWaitNotReleaseMonitor = new SleepWaitNotReleaseMonitor();
        Thread thread = new Thread(sleepWaitNotReleaseMonitor);
        Thread thread2 = new Thread(sleepWaitNotReleaseMonitor);
        thread.start();
        thread2.start();
    }
}
