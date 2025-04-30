package com.zedthm.leetcode.leetcode75.dp_multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/30 13:21
 * @description:
 */
public class LeetCode72 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine().trim();
        String word2 = br.readLine().trim();
        int result = minDistance(word1, word2);
    }

    private static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        // 边界条件处理
        if (m * n == 0) {
            return m + n; // 任一字符串为空的情况
        }

        // DP表初始化 (m+1)*(n+1)
        int[][] dp = new int[m + 1][n + 1];

        // 初始化基准情况
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // 删除所有字符
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // 插入所有字符
        }

        // 状态转移填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 字符匹配时直接继承前序状态
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 三种操作取最小值：替换/插入/删除
                    dp[i][j] = 1 + Math.min(
                            Math.min(
                                    dp[i - 1][j],   // 删除操作
                                    dp[i][j - 1]),  // 插入操作
                            dp[i - 1][j - 1]      // 替换操作
                    );
                }
            }
        }
        return dp[m][n];
    }
}
