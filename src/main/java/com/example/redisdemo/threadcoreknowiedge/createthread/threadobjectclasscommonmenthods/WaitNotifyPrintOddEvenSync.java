package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

public class WaitNotifyPrintOddEvenSync {
private static Object object = new Object();
 private  static  int count = 0;
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    synchronized (object){
                        if((count & 1) == 1){
                            System.out.println("奇数线程打印"+count);
                            count =count+1;
                        }
                    }
                }
            }
        }, "奇数");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while ((count & 1) == 0) {
                    synchronized (object){
                        System.out.println("偶数线程打印" + count);
                        count = count + 1;
                    }
                }
            }
        }, "偶数");

        thread.start();
        thread1.start();
    }


}
