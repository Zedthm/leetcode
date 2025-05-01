package com.zedthm.leetcode.leetcode75.slidewindow;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/1 15:33
 * @description:
 * 右扩找可行，左缩求最优
 * 匹配用计数，哈希表跟踪
 */
public class LeetCode76 {
    public static void main(String[] args) {

    }

    static class Solution {
        public String minWindow(String s, String t) {
            // 初始化目标字符计数表
            int[] target = new int[128];
            for (char c : t.toCharArray()) {
                target[c]++;
            }

            // 滑动窗口指针及状态变量
            int left = 0, right = 0;
            int matched = 0;           // 已匹配的字符数
            int minLen = Integer.MAX_VALUE;
            int minStart = 0;          // 最小窗口起始位置

            //扩展右界：目标字符减计数，匹配数增加
            //收缩左界：字符计数恢复，匹配数减少
            while (right < s.length()) {
                // 扩展右边界：处理当前字符并更新匹配状态
                char rc = s.charAt(right++);
                if (--target[rc] >= 0) {
                    matched++; // 关键匹配判断
                }

                // 当窗口满足条件时收缩左边界
                while (matched == t.length()) {
                    // 更新最小窗口记录
                    if (right - left < minLen) {
                        minLen = right - left;
                        minStart = left;
                    }

                    // 收缩左边界并恢复计数
                    char lc = s.charAt(left++);
                    if (++target[lc] > 0) {
                        matched--; // 关键状态回退
                    }
                }
            }

            return minLen == Integer.MAX_VALUE ? ""
                    : s.substring(minStart, minStart + minLen);
        }
    }
}
