package com.example.redisdemo.threadcoreknowiedge.createthread.threaderror;


import java.util.concurrent.atomic.AtomicInteger;

/**
 *  第一种，运行结果出错，
 */
public class MultiThreadError implements Runnable
{
    private static int index=0;
    final boolean[] marked = new boolean[1000000];
    private static AtomicInteger realIndex = new AtomicInteger();
    private static AtomicInteger wrongIndex = new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index++;
            realIndex.incrementAndGet();
            if(marked[index]){
                wrongIndex.incrementAndGet();
            }
            marked[index] = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadError runnable = new MultiThreadError();
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("表面执行数量"+index);
        System.out.println("实际执行次数"+realIndex);
        System.out.println("错误次数"+wrongIndex);
    }
}
