package com.leetcode75.queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 14:37
 * @description:
 */
public class LeetCode933 {
    public static void main(String[] args) throws IOException {

    }
    static class RecentCounter {
        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

}
