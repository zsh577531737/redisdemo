package com.example.redisdemo.threadcoreknowiedge.createthread.sixstates;

public class BlockedWaitingTimedWaiting implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread.sleep(200);
        // 打印出timed_watting状态，因为正在执行Thread.sleep(1000);
        System.out.println(thread1.getState());
        // 打印出blocked状态，因为thread2想要拿到sync的锁却拿不到
        System.out.println(thread2.getState());
        Thread.sleep(1500);
        // 打印出watting状态，因为thread1调用了this.wait();
        System.out.println(thread1.getState());
    }
    @Override
    public void run() {
        sync();
    }
    public synchronized void sync(){
        try {
            Thread.sleep(1000);
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
