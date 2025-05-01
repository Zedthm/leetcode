package com.zedthm.leetcode.leetcode75.slidewindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/1 15:06
 * @description: 堆解决中位数
 */
public class LeetCode295 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
    class MedianFinder {
        // 大根堆存较小半区（堆顶是最大元素）
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 小根堆存较大半区（堆顶是最小元素）
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void addNum(int num) {
            // 插入策略：优先比较大根堆顶
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            // 平衡堆大小（核心操作）
            balanceHeaps();
        }

        private void balanceHeaps() {
            // Case 1: 大堆元素过多 → 转移到大堆顶到小堆
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
            // Case 2: 小堆比大堆多超过1个 → 转移小堆顶到大堆
            else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            // 奇数取小堆顶，偶数取平均
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }
}
