package com.zedthm.leetcode.hot100.slideWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/29 19:29
 * @description:
 * 处理边界情况：如果s的长度小于p的长度，返回空列表。
 * 初始化pCount数组，统计p中各字符的出现次数。
 * 初始化sCount数组，统计s的前pLen个字符的出现次数。
 * 比较pCount和sCount，如果相等，将0加入结果列表。
 * 循环遍历i从pLen到s.length()-1：
 * a. 移除窗口左边的字符（i-pLen位置的字符），sCount中对应位置减1。
 * b. 添加当前i位置的字符到sCount中，对应位置加1。
 * c. 比较sCount和pCount，如果相等，将i-pLen+1加入结果列表。
 * 返回结果列表。
 */
public class LeetCode438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String p = br.readLine().trim();
        List<Integer> result = findAnagrams(s, p);
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return result;

        // 字符频率记录数组
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // 初始化频率数组
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // 初始窗口检查
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // 滑动窗口主循环
        for (int i = pLen; i < sLen; i++) {
            // 移除窗口左边界字符
            char leftChar = s.charAt(i - pLen);
            sCount[leftChar - 'a']--;

            // 添加窗口右边界字符
            char rightChar = s.charAt(i);
            sCount[rightChar - 'a']++;

            // 检查频率匹配
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }


    private static List<Integer> findAnagramsOptimized(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return result;
        }

        int[] count = new int[26];
        int matches = 0; // 匹配字符计数器

        // 初始化p的字符频率
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < sLen; right++) {
            char c = s.charAt(right);

            // 处理右边界字符
            if (--count[c - 'a'] >= 0) {
                matches++;
            }

            // 窗口超过长度时处理左边界
            if (right - left + 1 > pLen) {
                char leftChar = s.charAt(left++);
                if (++count[leftChar - 'a'] > 0) {
                    matches--;
                }
            }

            // 检查匹配数
            if (matches == pLen) {
                result.add(left);
            }
        }

        return result;
    }
}
