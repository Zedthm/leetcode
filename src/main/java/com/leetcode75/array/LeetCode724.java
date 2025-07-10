package com.leetcode75.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 12:16
 * @description:
 */
public class LeetCode724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(new Solution().pivotIndex(arr));
    }

    static class Solution {
        public int pivotIndex(int[] nums) {
            // 1. 计算数组总和
            int total = 0;
            for (int num : nums) {
                total += num;
            }

            // 2. 初始化左侧累加和
            int leftSum = 0;

            // 3. 遍历每个位置寻找中心下标
            for (int i = 0; i < nums.length; i++) {
                // 4. 检查当前中心下标条件
                if (2 * leftSum + nums[i] == total) {
                    return i;
                }
                // 5. 更新左侧和（为下一个位置准备）
                leftSum += nums[i];
            }

            // 6. 未找到有效中心下标
            return -1;
        }
    }
}
