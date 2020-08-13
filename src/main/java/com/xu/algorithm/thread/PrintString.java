package com.xu.algorithm.thread;

import lombok.AllArgsConstructor;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/3.
 * <p>
 * 交替打印字符串ABC
 * <p>
 * 建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * <p>
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印
 */
public class PrintString {

    //wait 和 notify  +  synchronized 控制
    @Test
    public void print1Test() throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();
        Print1Thread a = new Print1Thread("A", lockC, lockA);
        Print1Thread b = new Print1Thread("B", lockA, lockB);
        Print1Thread c = new Print1Thread("C", lockB, lockC);
        new Thread(a).start();
        //保证线程顺序
        Thread.sleep(10);
        new Thread(b).start();
        Thread.sleep(10);
        new Thread(c).start();
    }

    @AllArgsConstructor
    class Print1Thread implements Runnable {

        private String name;
        private Object pre;
        private Object current;

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (pre) {
                    synchronized (current) {
                        System.out.printf(name);
                        count--;
                        // 唤醒其他线程竞争current锁，注意此时current锁并未立即释放。
                        current.notifyAll();
                    }
                    //此时执行完current的同步块，这时current锁才释放。
                    if (count == 0) {
                        // 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁
                        pre.notifyAll();
                    } else {
                        try {
                            // 立即释放 prev锁，当前线程休眠，等待唤醒
                            pre.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
