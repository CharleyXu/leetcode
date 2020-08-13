package com.xu.algorithm.structure.queue;

import com.xu.algorithm.structure.stack.Stack;

/**
 * Created by CharleyXu on 2020-08-11
 * <p>
 * 两个栈实现一个FIFO队列
 */
public class TwoStackAchieveQueue {

    private Stack<Integer> stack1 = new Stack<>();

    private Stack<Integer> stack2 = new Stack<>();

    public void push(int num) {
        stack1.push(num);
    }

    public int pop() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
