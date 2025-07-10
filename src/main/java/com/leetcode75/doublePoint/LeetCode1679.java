package com.leetcode75.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/4 13:18
 * @description:
 */
public class LeetCode1679 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int k = Integer.parseInt(br.readLine().trim());
        System.out.println(new Solution().maxOperations(arr, k));
    }
    static class Solution {
        public int maxOperations(int[] nums, int k) {
            // 步骤1：统计每个数字出现的频率
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            int operations = 0; // 记录操作次数（配对次数）
            // 步骤2：遍历每个数字
            for (int num : freqMap.keySet()) {
                // 情况1：自身配对（num 出现两次可配一对）
                if (2 * num == k) {
                    // 如 num=3, k=6：三个3最多配1对（需要两个3）
                    operations += freqMap.get(num) / 2;
                }
                // 情况2：交叉配对（仅处理 num < k - num 避免重复）
                else if (num < k - num) {
                    int complement = k - num; // 互补数
                    if (freqMap.containsKey(complement)) {
                        // 可配对数由较少的一方决定
                        operations += Math.min(freqMap.get(num), freqMap.get(complement));
                    }
                }
                // 情况3：num > k - num 时跳过（其互补项已在较小值中处理）
            }
            return operations;
        }
    }
}
