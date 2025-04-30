package com.zedthm.leetcode.leetcode75.dp_single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/30 14:39
 * @description:
 */
public class LeetCode746 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] cost = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            cost[i] = Integer.parseInt(arrStr[i]);
        }
        int result = minCostClimbingStairs(cost);
    }

    /**
     * 标准动态规划模板 - 最小花费爬楼梯
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * 核心思想：
     * 1. 每个台阶的花费只与前两个台阶相关
     * 2. 状态转移方程：dp[i] = min(前1步上来, 前2步上来) + 当前台阶花费
     * 3. 最终结果在顶层（第n个台阶之后）
     */
    private static int minCostClimbingStairs(int[] cost) {
        // 边界条件处理（根据题目约束，cost.length >= 2）
        if (cost == null || cost.length == 0) {
            return 0;
        }

        int n = cost.length;
        int[] dp = new int[n + 1]; // dp[i]表示到达第i阶的最小累计花费

        // 初始化基准状态（可以从0或1阶直接开始，无需花费）
        dp[0] = 0;  // 站在0阶（地面）
        dp[1] = 0;  // 站在1阶（题目允许从0或1开始）

        // 状态转移：计算到达每个台阶的最小花费
        for (int i = 2; i <= n; i++) {
            // 状态转移方程：从前一阶或前两阶过来，取最小值加上当前台阶花费
            dp[i] = Math.min(
                    dp[i-1] + cost[i-1],  // 从i-1阶走1步上来
                    dp[i-2] + cost[i-2]   // 从i-2阶走2步上来
            );
        }
        return dp[n]; // 到达顶层（第n阶之后）的最小花费
    }
}
