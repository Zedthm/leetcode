package com.zedthm.leetcode.leetcode75.dp_single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/30 14:50
 * @description:
 */
public class LeetCode790 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int result = numTilings(n);
    }

    /**
     * 标准动态规划模板 - 多米诺和托米诺平铺
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * 核心思想：
     * 1. 定义四种状态：
     *    - 0: 当前列完全覆盖（下一列无延伸）
     *    - 1: 当前列覆盖后，下一列上方突出一个格子
     *    - 2: 当前列覆盖后，下一列下方突出一个格子
     *    - 3: 当前列和下一列同时被覆盖（使用L型砖块）
     * 2. 状态转移方程基于不同砖块的组合方式
     */
    private static int numTilings(int n) {
        if (n == 0) {
            return 1; // 空铺法
        }
        if (n == 1) {
            return 1;
        }

        // DP表：dp[i][s] 表示前i列在状态s下的铺法数
        int[][] dp = new int[n + 1][4];

        // 初始化基准状态
        dp[0][3] = 1; // 没有列时的完全覆盖状态

        for (int i = 1; i <= n; i++) {
            // 状态转移方程
            dp[i][0] = dp[i - 1][3] % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD
                    + (dp[i - 1][2] + dp[i - 1][3]) % MOD)) % MOD;
        }
        return dp[n][3]; // 最终必须完全覆盖
    }

}
