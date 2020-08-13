package com.xu.algorithm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.AllArgsConstructor;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/3.
 *
 * 交替打印数字
 */
public class PrintNumber {

  //wait 、 notify 和 synchronized 联用
  private static int count = 1;

  @Test
  public void printNumber01Test() throws InterruptedException {
    Object object = new Object();
    PrintNumberThread01 printNumberThread =
        new PrintNumberThread01("Thread1-1-", object, 1);
    PrintNumberThread01 printNumberThread2 =
        new PrintNumberThread01("Thread1-2-", object, 0);
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.execute(printNumberThread);
    Thread.sleep(100);
    executorService.execute(printNumberThread2);
  }

  @AllArgsConstructor
  class PrintNumberThread01 implements Runnable {

    private String threadName;
    private Object object;
    private int type;

    @Override
    public void run() {
      while (count <= 10) {
        synchronized (object) {
          if (count % 2 == type) {
            System.out.println(threadName + count++);
          } else {
            object.notifyAll();
            try {
              object.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }
  }

  @Test
  public void printNumber02Test() {

  }


}
