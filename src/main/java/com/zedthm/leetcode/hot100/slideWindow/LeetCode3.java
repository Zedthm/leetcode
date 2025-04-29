package com.zedthm.leetcode.hot100.slideWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/29 19:10
 * @description:
 */
public class LeetCode3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int result = lengthOfLongestSubstring(line);
    }

    private static int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            while (list.contains(s.charAt(i))) {
                list.remove(0);
            }
            list.add(s.charAt(i));
            max = Math.max(max, list.size());
        }
        return max;
    }

    private static int lengthOfLongestSubstring_2(String s) {
        // 边界条件检测
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 窗口指针初始化
        int left = 0;          // 窗口左边界
        int right = 0;         // 窗口右边界
        int maxLen = 0;        // 记录最大长度
        Set<Character> window = new HashSet<>(); // 窗口字符集合

        // 主循环：移动右边界
        while (right < s.length()) {
            char c = s.charAt(right);

            // 窗口收缩：当遇到重复字符时移动左边界
            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }

            // 窗口扩展：将当前字符加入窗口
            window.add(c);

            // 更新最大值：当前窗口长度 right-left+1
            maxLen = Math.max(maxLen, right - left + 1);

            // 移动右边界
            right++;
        }

        return maxLen;
    }

    public static int lengthOfLongestSubstring_optimized(String s) {
        // 边界条件检测
        if (s == null || s.length() == 0) {
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
