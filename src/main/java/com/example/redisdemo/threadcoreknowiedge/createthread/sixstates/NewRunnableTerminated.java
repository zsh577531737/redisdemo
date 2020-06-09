package com.example.redisdemo.threadcoreknowiedge.createthread.sixstates;

/**
 * 展示线程的NEW、RUNNABLE、TERMINATED状态。
 * 即使是正在运行，也是Runnable状态
 */
public class NewRunnableTerminated implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try{
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(thread.getState());
        try{
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println(i);
        }

    }
}
