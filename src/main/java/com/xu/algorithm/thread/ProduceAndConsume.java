package com.xu.algorithm.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by CharleyXu on 2020-08-24
 */
public class ProduceAndConsume {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Customer customer = new Customer(queue);
        Producer producer = new Producer(queue);
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer a = customer.removeObject();
                System.out.println("消费了数据 " + a);
            });
            pool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Random random = new Random();
                Integer a = random.nextInt(1000);
                System.out.println("生成了数据 " + a);
                producer.addObject(a);
            });
        }
    }

    private static class Customer {
        Queue<Integer> queue;

        Customer(Queue<Integer> queue) {
            this.queue = queue;
        }

        public Integer removeObject() {
            synchronized (queue) {
                try {
                    while (queue.size() == 0) {
                        System.out.println("队列中没有元素了，进行等待");
                        queue.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer number = queue.poll();
                System.out.println("唤醒所有生产线程，当前queue大小是" + queue.size());
                queue.notifyAll();
                return number;
            }
        }
    }

    private static class Producer {
        Queue<Integer> queue;

        Producer(Queue<Integer> queue) {
            this.queue = queue;
        }

        public void addObject(Integer number) {
            synchronized (queue) {
                try {
                    while (queue.size() > 10) {
                        queue.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.add(number);
                queue.notifyAll();
                System.out.println("唤醒所有消费线程，当前queue大小是" + queue.size());
            }
        }
    }

}
