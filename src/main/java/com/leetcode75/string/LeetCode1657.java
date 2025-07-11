package com.leetcode75.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.SortedMap;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 13:00
 * @description:
 */
public class LeetCode1657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine().trim();
        String str2 = br.readLine().trim();
        System.out.println(new Solution().closeStrings(str1, str2));
    }
    static class Solution {
        public boolean closeStrings(String word1, String word2) {
            // Step 1: 检查长度是否相等
            if (word1.length() != word2.length()) {
                return false;
            }

            // 创建两个频次数组（对应26个小写字母）
            int[] freq1 = new int[26]; // 统计word1中各字符出现次数
            int[] freq2 = new int[26]; // 统计word2中各字符出现次数

            // Step 2: 遍历两个字符串，更新频次数组
            for (char c : word1.toCharArray()) {
                freq1[c - 'a']++; // 'a'对应索引0，'b'对应1，以此类推
            }
            for (char c : word2.toCharArray()) {
                freq2[c - 'a']++;
            }

            // Step 3: 检查字符集合是否一致
            for (int i = 0; i < 26; i++) {
                // 条件：字符在word1出现则在word2也必须出现（反之亦然）
                if ((freq1[i] > 0 && freq2[i] == 0) || (freq1[i] == 0 && freq2[i] > 0)) {
                    return false;
                }
            }

            // Step 4: 对频次数组排序（升序）
            Arrays.sort(freq1);
            Arrays.sort(freq2);

            // Step 5: 比较排序后的频次数组
            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) {
                    return false;
                }
            }

            // 全部条件满足，返回true
            return true;
        }
    }
}
