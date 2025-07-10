package com.leetcode75.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/4 12:58
 * @description:
 */
public class LeetCode392 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String t = br.readLine().trim();
        System.out.println(new Solution().isSubsequence(s,t));
    }
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            // 处理s为空的情况
            if (s.isEmpty()) return true;

            int sPointer = 0; // s的指针
            char target = s.charAt(sPointer); // 当前需要匹配的字符

            // 遍历t字符串
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);

                // 如果匹配到当前需要的字符
                if (c == target) {
                    sPointer++; // 移动到s的下一个字符

                    // 如果s已全部匹配完成
                    if (sPointer == s.length()) {
                        return true;
                    }

                    // 更新需要匹配的下一个字符
                    target = s.charAt(sPointer);
                }
            }

            // t遍历完但s未匹配完
            return false;
        }
    }
}
