package com.xu.algorithm.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/5.
 * <p>
 * 用多线程去处理 "123","456","789" 三个字符串，
 * <p>
 * 然后以"147","258","369"输出
 */
public class PrintStrings {

    @Test
    public void printStrings() throws ExecutionException, InterruptedException {
        String str1 = "123", str2 = "456", str3 = "789";
        int length = 3;
        PrintCallable thread3 = new PrintCallable(str3, null);
        PrintCallable thread2 = new PrintCallable(str2, thread3);
        PrintCallable thread1 = new PrintCallable(str1, thread2);
        for (int i = 0; i < length; i++) {
            thread1.setIndex(i);
            FutureTask<String> futureTask = new FutureTask<>(thread1);
            new Thread(futureTask).start();
            System.out.println(futureTask.get());
        }

    }


    @AllArgsConstructor
    @Setter
    class PrintCallable implements Callable<String> {

        private String string;
        private int index;
        private PrintCallable next;

        public PrintCallable(String string, PrintCallable next) {
            this.string = string;
            this.next = next;
        }

        @Override
        public String call() throws Exception {
            if (next != null) {
                next.setIndex(index);
                FutureTask<String> futureTask = new FutureTask<>(next);
                new Thread(futureTask).start();
                return string.charAt(index) + futureTask.get();
            }
            return String.valueOf(string.charAt(index));
        }
    }
}
