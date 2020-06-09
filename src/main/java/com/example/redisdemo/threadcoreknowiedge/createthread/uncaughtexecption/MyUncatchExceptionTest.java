package com.example.redisdemo.threadcoreknowiedge.createthread.uncaughtexecption;

/**
 * 测试自定义异常捕获
 */
public class MyUncatchExceptionTest implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncatchException("捕获器"));
        new Thread(new MyUncatchExceptionTest()).start();
        Thread.sleep(200);
        new Thread(new MyUncatchExceptionTest()).start();
        Thread.sleep(200);
        new Thread(new MyUncatchExceptionTest()).start();
        Thread.sleep(200);
        new Thread(new MyUncatchExceptionTest()).start();
    }
}
