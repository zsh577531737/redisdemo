package com.example.redisdemo.threadcoreknowiedge.createthread;


/**
 * 使用Runnable实现线程
 */
public class RunnableStyle implements Runnable{
    @Override
    public void run() {
        System.out.println("使用Runnable实现");
    }

    public static void main(String[] args) {

            RunnableStyle runnableStyle = new RunnableStyle();
            Thread thread  = new Thread(runnableStyle);
            thread.start();
    }
}
