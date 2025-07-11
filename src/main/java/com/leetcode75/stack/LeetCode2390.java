package com.leetcode75.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 13:44
 * @description:
 */
public class LeetCode2390 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        System.out.println(new Solution().removeStars(line));
    }

    static class Solution {
        public String removeStars(String s) {
            // 使用栈结构存储有效字符
            StringBuilder stack = new StringBuilder();

            // 遍历字符串中的每个字符
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '*') {
                    // 遇到星号：弹出栈顶元素（删除左侧最近的非星号字符）
                    stack.deleteCharAt(stack.length() - 1);
                } else {
                    // 非星号字符：压入栈中
                    stack.append(c);
                }
            }

            // 栈中字符按顺序组成最终结果
            return stack.toString();
        }
    }
}
