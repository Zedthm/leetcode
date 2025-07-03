package com.leetcode75.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 17:31
 * @description:
 */
public class LeetCode151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        System.out.println(new Solution().reverseWords(s));
    }

    static class Solution {
        public String reverseWords(String s) {
            // 转换为字符数组（方便操作）
            char[] chars = s.toCharArray();

            // 1. 去除多余空格（双指针法）
            int n = removeExtraSpaces(chars);
            if (n == 0) return ""; // 处理全空字符串

            // 2. 反转整个字符串
            reverse(chars, 0, n - 1);

            // 3. 反转每个单词
            reverseEachWord(chars, n);

            // 构建最终结果
            return new String(chars, 0, n);
        }

        // 双指针法去除多余空格（返回有效长度）
        private int removeExtraSpaces(char[] chars) {
            int slow = 0; // 慢指针：标记新字符串位置
            int fast = 0; // 快指针：扫描原数组

            // 跳过前导空格
            while (fast < chars.length && chars[fast] == ' ') fast++;

            // 核心处理逻辑
            while (fast < chars.length) {
                // 如果不是空格，直接复制
                if (chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
                // 如果是空格
                else {
                    // 复制一个空格（单词分隔符）
                    chars[slow++] = ' ';
                    // 跳过后续所有连续空格
                    while (fast < chars.length && chars[fast] == ' ') fast++;
                }
            }

            // 处理尾随空格：如果最后有多余空格，slow回退
            return (slow > 0 && chars[slow - 1] == ' ') ? slow - 1 : slow;
        }

        // 反转指定区间的字符
        private void reverse(char[] chars, int start, int end) {
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }

        // 反转每个单词（根据空格确定边界）
        private void reverseEachWord(char[] chars, int n) {
            int start = 0; // 单词起始位置
            for (int i = 0; i <= n; i++) {
                // 遇到空格或结尾时反转单词
                if (i == n || chars[i] == ' ') {
                    reverse(chars, start, i - 1);
                    start = i + 1; // 更新下一单词起始位置
                }
            }
        }
    }
}
