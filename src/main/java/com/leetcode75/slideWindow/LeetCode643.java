package com.leetcode75.slideWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/4 13:34
 * @description:
 */
public class LeetCode643 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int k = Integer.parseInt(br.readLine().trim());
        System.out.println(new Solution().findMaxAverage(arr, k));
    }

    static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            // 1. 初始化窗口：计算第一个窗口的和
            int windowSum = 0;
            for (int i = 0; i < k; i++) {
                windowSum += nums[i];
            }
            // 当前最大和初始化为第一个窗口和
            int maxSum = windowSum;

            // 2. 滑动窗口：从k位置开始向右滑动
            for (int i = k; i < nums.length; i++) {
                // 减去窗口左边离开的元素
                windowSum -= nums[i - k];
                // 加上窗口右边新增的元素
                windowSum += nums[i];
                // 更新最大窗口和
                if (windowSum > maxSum) {
                    maxSum = windowSum;
                }
            }

            // 3. 最终结果：最大窗口和÷k (转换为double保证精度)
            return (double) maxSum / k;
        }
    }
}
