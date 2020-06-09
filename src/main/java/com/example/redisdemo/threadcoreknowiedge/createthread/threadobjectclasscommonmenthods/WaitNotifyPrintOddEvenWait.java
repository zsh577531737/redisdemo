package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;


/**
 * 使用两个线程（通过wait、notify方式）打印奇偶数
 */
public class WaitNotifyPrintOddEvenWait implements Runnable{
    private static int count = 0;

    private static Object object = new Object();
    public static void main(String[] args) {
        WaitNotifyPrintOddEvenWait waitNotifyPrintOddEvenWait = new WaitNotifyPrintOddEvenWait();
        Thread thread = new Thread(waitNotifyPrintOddEvenWait);
        Thread thread2 = new Thread(waitNotifyPrintOddEvenWait);
        thread.start();
        thread2.start();
    }

    @Override
    public void run() {
        while (count < 100){
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+count);
                count++;
                object.notify();
                if(count<100){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
