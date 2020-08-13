package com.xu.algorithm.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.Semaphore;

/**
 * Created by CharleyXu on 2020-08-07
 */
public class ProducerAndConsumerSemaphore {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerAndConsumerSemaphore.class);

    /***
     数据仓储class，所有的producer和consumer共享这个class对象
     **/
    static class DataWareHouse {
        //共享数据区
        private final Queue<String> data = new LinkedList<>();
        //非满锁
        private final Semaphore notFull;
        //非空锁
        private final Semaphore notEmpty;
        //互斥锁
        private final Semaphore mutex;

        public DataWareHouse(int capacity) {
            this.notFull = new Semaphore(capacity);
            this.notEmpty = new Semaphore(0);
            mutex = new Semaphore(1);
        }

        public void offer(String x) throws InterruptedException {
            notFull.acquire(); //producer获取信号，notFull信号量减一
            mutex.acquire(); //当前进程获得信号，mutex信号量减1，其他线程被阻塞操作共享区块data
            data.add(x);
            mutex.release(); //mutex信号量+1, 其他线程可以继续信号操作共享区块data
            notEmpty.release(); //成功生产数据，notEmpty信号量加1
        }

        public String poll() throws InterruptedException {
            notEmpty.acquire(); //notEmpty信号减一
            mutex.acquire();
            String result = data.poll();
            mutex.release();
            notFull.release(); //成功消耗数据, notFull信号量加1
            return result;
        }
    }

    /**
     * Producer线程
     **/
    static class Producer implements Runnable {
        private final DataWareHouse dataWareHouse;

        public Producer(final DataWareHouse dataWareHouse) {
            this.dataWareHouse = dataWareHouse;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100); //生产的速度慢于消耗的速率
                    String s = UUID.randomUUID().toString();
                    LOGGER.info("put  data " + s);
                    dataWareHouse.offer(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Consumer线程
     **/
    static class Consumer implements Runnable {
        private final DataWareHouse dataWareHouse;

        public Consumer(final DataWareHouse dataWareHouse) {
            this.dataWareHouse = dataWareHouse;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    LOGGER.info("get data " + dataWareHouse.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //测试代码
    public static void main(String[] args) {
        final DataWareHouse dataWareHouse = new DataWareHouse(5);
        //三个producer 持续生产
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Producer(dataWareHouse));
            t.start();
        }
        //三个consumer 持续消耗
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Consumer(dataWareHouse));
            t.start();
        }
    }
}
