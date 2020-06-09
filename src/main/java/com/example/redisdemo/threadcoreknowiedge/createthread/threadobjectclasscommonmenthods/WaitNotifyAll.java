package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

/**
 * 使用notifuAll唤醒所有正在等待的
 */
public class WaitNotifyAll implements Runnable{
    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyAll waitNotifyAll = new WaitNotifyAll();
        Thread thread1 = new Thread(waitNotifyAll);
        Thread thread2 = new Thread(waitNotifyAll);

        Thread thread3 = new Thread(){
            @Override
            public void run() {
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"开始执行thread2");
                    object.notifyAll();
                    System.out.println(Thread.currentThread().getName()+"执行完成");
                }
            }
        };
        thread1.start();
        thread2.start();
        Thread.sleep(200);
        thread3.start();
    }

    @Override
    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"开始执行thread1");
            try {
                object.wait();
                System.out.println(Thread.currentThread().getName()+"结束thread1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
