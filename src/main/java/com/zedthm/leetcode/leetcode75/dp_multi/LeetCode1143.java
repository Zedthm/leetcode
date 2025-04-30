package com.zedthm.leetcode.leetcode75.dp_multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/30 13:57
 * @description:
 */
public class LeetCode1143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text1 = br.readLine().trim();
        String text2 = br.readLine().trim();
        int result = longestCommonSubsequence(text1, text2);
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int text1Length = text1.length();
        int text2Length = text2.length();

        // 边界条件处理
        if (text1Length == 0 || text2Length == 0) {
            return 0;
        }

        int[][] dp = new int[text1Length + 1][text2Length + 1];

        // 初始化：空字符串和任何字符串的最长公共子序列的长度都是 0
        for (int i = 0; i <= text1Length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= text2Length; j++) {
            dp[0][j] = 0;
        }

        // 状态转移填表
        for (int i = 1; i <= text1Length; i++) {
            char c1 = text1.charAt(i - 1); // 当前text1字符
            for (int j = 1; j <= text2Length; j++) {
                char c2 = text2.charAt(j - 1); // 当前text2字符

                if (c1 == c2) {
                    // 字符匹配：LCS长度增加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 字符不匹配：取左方或上方的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1Length][text2Length];
    }
}
