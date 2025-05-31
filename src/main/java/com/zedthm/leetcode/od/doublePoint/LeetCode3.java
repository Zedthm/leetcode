package com.zedthm.leetcode.od.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/16 12:19
 * @description:
 */
public class LeetCode3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int result = new Solution().lengthOfLongestSubstring(line);
        System.out.println(result);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 边界条件检测
            if (s == null || s.isEmpty()) {
                return 0;
            }

            int maxLen = 0;
            int[] indexMap = new int[128]; // ASCII字符集索引

            // 窗口指针初始化
            int left = 0;

            // 主循环：移动右边界
            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);

                // 直接跳跃左边界到重复字符的下一个位置
                left = Math.max(left, indexMap[c]);

                // 更新当前字符的最新位置（下标从1开始计算）
                indexMap[c] = right + 1;

                // 计算当前窗口长度
                maxLen = Math.max(maxLen, right - left + 1);
            }

            return maxLen;
        }
    }
}
