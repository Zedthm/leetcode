package com.zedthm.leetcode.baize.dataStruct.arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/3 9:49
 * @description:
 */
public class LeetCode232 {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public LeetCode232() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int val) {
        inStack.push(val);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        assert outStack.peek() != null;
        return outStack.peek();
    }

    public boolean empty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
