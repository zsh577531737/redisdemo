package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

public class JoinMainState {

    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("主线程状态"+mainThread.getState());
                    System.out.println("子线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        System.out.println("线程结束");

    }
}
