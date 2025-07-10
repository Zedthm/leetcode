package com.leetcode75.slideWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 11:56
 * @description:
 */
public class LeetCode1493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(new Solution().longestSubarray(arr));
    }

    static class Solution {
        public int longestSubarray(int[] nums) {
            int maxLength = 0;      // 最大连续1长度（删除0后）
            int zeroCount = 0;      // 当前窗口中的0的数量
            int left = 0;           // 窗口左边界

            // 全部是 0 的情况，返回 0
            for (int num : nums) {
                if (num == 0) {
                    zeroCount ++;
                }
            }

            if (zeroCount == nums.length) {
                return 0;
            }

            zeroCount = 0;

            // 右指针遍历整个数组
            for (int right = 0; right < nums.length; right++) {
                // 遇到0时增加计数器
                if (nums[right] == 0) {
                    zeroCount++;
                }

                // 收缩窗口：当0的数量超过1时
                while (zeroCount > 1) {
                    // 左边界遇到0时减少计数器
                    if (nums[left] == 0) {
                        zeroCount--;
                    }
                    left++;  // 无论是否0，左指针右移
                }

                // 计算当前有效长度（窗口长度-1：因为要删除一个元素）
                int currentLength = right - left;  // 注意：这里不减1是因为还没有加1
                maxLength = Math.max(maxLength, currentLength);
            }

            // 处理全1数组的特殊情况（必须删除一个元素）
            return maxLength == 0 ? nums.length - 1 : maxLength;
        }
    }
}
