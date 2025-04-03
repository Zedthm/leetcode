package com.zedthm.leetcode.baize.dataStruct.arrays;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/3 10:00
 * @description:
 */
public class LeetCode225 {
    Queue<Integer> queue;
    public LeetCode225() {
        queue = new LinkedList<>();
    }

    public void push(int val) {
        int n = queue.size();
        queue.offer(val);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
