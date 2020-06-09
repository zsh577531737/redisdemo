package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义实现消费者生产者
 */
public class ProducerConsumerModel
{

    public static void main(String[] args) {
        EventStorage eventStorage =  new EventStorage();
        Thread thread = new Thread(new Producer(eventStorage));
        Thread thread2 = new Thread(new Consumer(eventStorage));
        thread.start();
        thread2.start();

    }
}
class EventStorage{
    private Integer max;
    private LinkedList<String> list ;

    public EventStorage() {
        this.max = 10;
        this.list = new LinkedList<>();
    }

    public synchronized void put(String value){
        while (this.list.size() == this.max){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(value);
        System.out.println("现在仓库数量："+list.size());
        notify();

    }
    public synchronized void take(){
        while (this.list.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了："+list.poll()+"现在仓库还剩下："+list.size());
        notify();
        }
}
class Producer implements Runnable{
    private EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            eventStorage.put(i+"");
        }

    }
}

class Consumer implements Runnable{
    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            eventStorage.take();
        }
    }
}
