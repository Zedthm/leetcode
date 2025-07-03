package com.leetcode75.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 18:25
 * @description:
 */
public class LeetCode443 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        char[] chars = new char[strs.length];
        for (int i = 0; i < strs.length; i++) {
            chars[i] = strs[i].charAt(0);
        }
        System.out.println(new Solution().compress(chars));
    }
    static class Solution {
        public int compress(char[] chars) {
            int n = chars.length;
            int write = 0; // 压缩结果写入位置

            for (int start = 0; start < n; ) {
                char current = chars[start]; // 当前字符
                int end = start + 1;         // 扫描连续字符的指针

                // 扫描连续字符区域
                while (end < n && chars[end] == current) {
                    end++;
                }

                // 计算连续长度
                int count = end - start;

                // 写入当前字符
                chars[write++] = current;

                // 当重复次数>1时写入数字
                if (count > 1) {
                    // 数字栈（存储各位数字）
                    char[] digits = new char[4]; // 2000以内最多4位数
                    int top = 0;

                    // 数字拆分
                    while (count > 0) {
                        digits[top++] = (char)('0' + count % 10); // 个位入栈
                        count /= 10; // 移除个位
                    }

                    // 倒序写入（高位先出）
                    while (top > 0) {
                        chars[write++] = digits[--top];
                    }
                }

                // 移动到下一段连续字符
                start = end;
            }

            return write; // 返回压缩后长度
        }
    }
}
