package com.example.redisdemo.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * 演示重排序现象
 */
public class OutOfOrderExecution {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;
    private static int index = 0;

    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            index++;
            x = y = a = b = 0;
            CountDownLatch latch = new CountDownLatch(1);
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            };
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            };
            thread1.start();
            thread2.start();
            latch.countDown();
            thread1.join();
            thread2.join();
            if (x == 0 && y == 0) {
                System.out.println("第" + index + "次，x = " + x + ", y= " + y);
                break;
            } else {
                System.out.println("第" + index + "次，x = " + x + ", y= " + y);
            }

        }
    }
}
