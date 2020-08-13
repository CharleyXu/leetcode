package com.xu.algorithm.thread;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CharleyXu on 2020-08-07
 */
public class ProducerAndConsumerLock {

    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;
    private int maxSize;
    private List<Date> storage;

    ProducerAndConsumerLock(int size) {
        //使用锁lock，并且创建两个condition，相当于两个阻塞队列
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        maxSize = size;
        storage = new LinkedList<>();
    }

    public void put() {
        lock.lock();
        try {
            while (storage.size() == maxSize) {//如果队列满了
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                notFull.await();//阻塞生产线程
            }
            storage.add(new Date());
            System.out.print(Thread.currentThread().getName() + ": put:" + storage.size() + "\n");
            Thread.sleep(1000);
            notEmpty.signalAll();//唤醒消费线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (storage.size() == 0) {//如果队列满了
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                notEmpty.await();//阻塞消费线程
            }
            Date d = ((LinkedList<Date>) storage).poll();
            System.out.print(Thread.currentThread().getName() + ": take:" + storage.size() + "\n");
            Thread.sleep(1000);
            notFull.signalAll();//唤醒生产线程

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 当生产者执行put方法时，调用notEmpty.signalAll()只会唤醒notEmpty.await()下的消费者线程
     * <p>
     * 当消费者执行take方法时，调用notFull.signalAll()只会唤醒notFull.await()下的消费者线程
     */
    public static void main(String[] arg) {
        ProducerAndConsumerLock buffer = new ProducerAndConsumerLock(10);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        for (int i = 0; i < 3; i++) {
            new Thread(producer, "producer-" + i).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(consumer, "consumer-" + i).start();
        }
    }


    private static class Producer implements Runnable {
        private ProducerAndConsumerLock buffer;

        Producer(ProducerAndConsumerLock b) {
            buffer = b;
        }

        @Override
        public void run() {
            while (true) {
                buffer.put();
            }
        }
    }

    private static class Consumer implements Runnable {
        private ProducerAndConsumerLock buffer;

        Consumer(ProducerAndConsumerLock b) {
            buffer = b;
        }

        @Override
        public void run() {
            while (true) {
                buffer.take();
            }
        }

    }

}
