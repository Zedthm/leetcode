package com.zedthm.leetcode.baize.dataStruct.arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/1 23:04
 * @description:
 */
public class LeetCode155 {

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public LeetCode155() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        assert xStack.peek() != null;
        minStack.push(Math.min(xStack.peek(), val));
    }

    public void pop(){
        xStack.pop();
        minStack.pop();
    }

    public int top () {
        assert xStack.peek() != null;
        return xStack.peek();
    }

    public int getMin() {
        assert minStack.peek() != null;
        return minStack.peek();
    }
    public static void main(String[] args) {

    }
}
