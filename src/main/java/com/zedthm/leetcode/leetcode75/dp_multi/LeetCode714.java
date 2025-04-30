package com.zedthm.leetcode.leetcode75.dp_multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/30 14:09
 * @description:
 */
public class LeetCode714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int fee = Integer.parseInt(br.readLine().trim());
        String[] arrStr = line.split(",");
        int[] prices = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            prices[i] = Integer.parseInt(arrStr[i]);
        }
        int result = maxProfit(prices, fee);
    }

    /**
     * 标准动态规划模板 - 含手续费的股票交易
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * 核心思想：
     * 1. 两种状态：持有股票/不持有股票
     * 2. 状态转移考虑交易费用
     * 3. 可优化至O(1)空间复杂度
     */
    private static int maxProfit(int[] prices, int fee) {
        // 边界条件处理
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;

        // DP表：dp[i][0]表示第i天不持有股票的最大利润
        //       dp[i][1]表示第i天持有股票的最大利润
        int[][] dp = new int[n][2];

        // 初始化基准状态
        dp[0][0] = 0;                   // 第一天不买入
        dp[0][1] = -prices[0];          // 第一天买入

        // 状态转移
        for (int i = 1; i < n; i++) {
            // 状态1：今天不持有股票 = 昨天也不持有 或 昨天持有今天卖出（需扣手续费）
            dp[i][0] = Math.max(
                    dp[i-1][0],
                    dp[i-1][1] + prices[i] - fee
            );

            // 状态2：今天持有股票 = 昨天也持有 或 昨天不持有今天买入
            dp[i][1] = Math.max(
                    dp[i-1][1],
                    dp[i-1][0] - prices[i]
            );
        }

        return dp[n-1][0]; // 最终不持有股票才能获得最大利润
    }
}
