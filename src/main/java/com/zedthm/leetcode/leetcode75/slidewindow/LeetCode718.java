package com.zedthm.leetcode.leetcode75.slidewindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/1 16:04
 * @description:
 */
public class LeetCode718 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    static class DP_Solution {
        public int findLength(int[] nums1, int[] nums2) {
            // 结果变量：记录最长公共子数组的长度
            int maxLength = 0;

            // 获取两个数组的长度（n、m为数组实际长度）
            int n = nums1.length;
            int m = nums2.length;

        /*
        DP表定义：dp[i][j]表示以nums1[i-1]和nums2[j-1]结尾的公共子数组的长度
        注意：数组下标从1开始，对应原数组的0~n-1和0~m-1
        */
            int[][] dp = new int[n + 1][m + 1]; // +1是为了避免处理边界条件

            // 遍历所有可能的子数组结束位置（i对应nums1，j对应nums2）
            for (int i = 1; i <= n; i++) {         // 遍历nums1的每个元素
                for (int j = 1; j <= m; j++) {     // 遍历nums2的每个元素

                /*
                关键逻辑：当两个数组当前元素相等时
                此时的公共子数组长度 = 前一个位置的公共子数组长度 + 1
                */
                    if (nums1[i - 1] == nums2[j - 1]) { // i-1和j-1对应原数组下标
                        dp[i][j] = dp[i - 1][j - 1] + 1; // 状态转移方程
                        maxLength = Math.max(maxLength, dp[i][j]); // 更新全局最大值
                    }

                /*
                隐含逻辑：当元素不相等时，dp[i][j] = 0
                因为题目要求的是连续子数组，所以一旦不连续，长度直接重置为0
                */
                }
            }

            return maxLength; // 返回找到的最大长度
        }
    }
}
