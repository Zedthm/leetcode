package com.leetcode75.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 18:14
 * @description:
 */
public class LeetCode334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
    }

    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            int n = nums.length;
            if (n < 3) return false;

            // 存储左侧最小值数组
            int[] leftMin = new int[n];
            // 存储右侧最大值数组
            int[] rightMax = new int[n];

            // 1. 计算左侧最小值
            leftMin[0] = Integer.MAX_VALUE; // 最左侧无元素
            for (int i = 1; i < n; i++) {
                leftMin[i] = Math.min(leftMin[i - 1], nums[i - 1]);
            }

            // 2. 计算右侧最大值
            rightMax[n - 1] = Integer.MIN_VALUE; // 最右侧无元素
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
            }

            // 3. 检查是否存在三元组
            for (int i = 1; i < n - 1; i++) {
                // 确保中间值同时大于左侧最小值和小于右侧最大值
                if (leftMin[i] < nums[i] && nums[i] < rightMax[i]) {
                    return true;
                }
            }

            return false;
        }
    }
}
