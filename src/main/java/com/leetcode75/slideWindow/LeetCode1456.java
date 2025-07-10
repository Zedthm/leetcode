package com.leetcode75.slideWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/4 13:40
 * @description:
 */
public class LeetCode1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int k = Integer.parseInt(br.readLine().trim());
        System.out.println(new Solution().maxVowels(s, k));
    }

    static class Solution {
        public int maxVowels(String s, int k) {
            // 1. 获取字符串长度（边界条件：k=0的情况由题目约束可忽略）
            int n = s.length();

            // 2. 初始化第一个窗口的元音数量
            String vowels = "aeiou";
            int vowelCount = 0;
            for (int i = 0; i < k; i++) {
                if (vowels.contains(s.charAt(i) + "")) {
                    vowelCount++;
                }
            }
            int maxVowels = vowelCount; // 当前最大元音数

            // 3. 滑动窗口处理（窗口范围：[i-k, i-1] → [i-k+1, i]）
            for (int i = k; i < n; i++) {
                // 移除窗口左侧元素（位置：i-k）
                char leftChar = s.charAt(i - k);
                if (vowels.contains(leftChar + "")) {
                    vowelCount--;
                }
                // 添加窗口右侧元素（位置：i）
                char rightChar = s.charAt(i);
                if (vowels.contains(rightChar + "")) {
                    vowelCount++;
                }
                // 更新最大值
                maxVowels = Math.max(maxVowels, vowelCount);
            }
            return maxVowels;
        }
    }
}
