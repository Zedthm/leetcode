package com.zedthm.leetcode.leetcode75.dp_multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/30 13:50
 * @description:
 */
public class LeetCode62 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        int result = uniquePaths(m, n);
    }

    private static int uniquePaths(int m, int n) {
        // 边界条件处理
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        // DP表初始化 (m x n)
        int[][] dp = new int[m][n];

        //初始化：第一行和第一列的所有位置都只有1种路径，因为机器人只能一直向右或向下走。
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // 第一列初始化
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // 第一行初始化
        }

        // 状态转移填表
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
