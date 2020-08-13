package com.xu.algorithm.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by CharleyXu on 2020-08-07
 */
public class ProducerAndConsumerBlockingQueue {

    private final BlockingQueue<String> blockingQueue;

    public ProducerAndConsumerBlockingQueue(int capacity) {
        this.blockingQueue = new ArrayBlockingQueue<>(capacity);
    }

    public void offer(String x) throws InterruptedException {
        blockingQueue.put(x);
    }

    public String poll() throws InterruptedException {
        return blockingQueue.take();
    }

}
