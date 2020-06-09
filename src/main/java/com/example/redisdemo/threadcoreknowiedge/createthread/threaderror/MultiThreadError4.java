package com.example.redisdemo.threadcoreknowiedge.createthread.threaderror;

/**
 * 初始化未完毕，就使用this赋值
 */
public class MultiThreadError4 {
    static Point point;


    public static void main(String[] args) throws InterruptedException {
        new PointMaker().start();
        Thread.sleep(105);
        System.out.println(point);
    }
}
    class Point {
        private int a,b;

        public Point(int a, int b) throws InterruptedException {
            this.a = a;
            MultiThreadError4.point = this;
            Thread.sleep(100);
            this.b = b;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    class PointMaker extends Thread{

        @Override
        public void run() {
            try {
                new Point(1,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

