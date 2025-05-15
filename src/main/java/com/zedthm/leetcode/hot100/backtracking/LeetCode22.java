package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/15 19:29
 * @description:
 */
public class LeetCode22 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Solution {
        List<String> result = new ArrayList<>(); // 存储最终结果
        char[] current; // 记录当前组合的字符数组
        int n; // 记录括号对数

        public List<String> generateParenthesis(int n) {
            this.n = n;
            current = new char[2 * n]; // 括号总数是2n
            backtrack(0, 0, 0); // 初始调用：位置0，左括号0，右括号0
            return result;
        }

        /**
         * 优化后的回溯算法（带剪枝）
         * @param pos 当前位置（范围0~2n-1）
         * @param left 已使用的左括号数量
         * @param right 已使用的右括号数量
         */
        void backtrack(int pos, int left, int right) {
            // 终止条件：所有位置填满
            if (pos == 2 * n) {
                result.add(new String(current));
                return;
            }

            // 选择1：尝试放左括号（需要满足左括号数量 < n）
            if (left < n) {
                current[pos] = '(';
                backtrack(pos + 1, left + 1, right); // 递归填下一个位置
            }

            // 选择2：尝试放右括号（需满足右括号数量 < 左括号数量）
            if (right < left) {
                current[pos] = ')';
                backtrack(pos + 1, left, right + 1); // 递归填下一个位置
            }
        }
    }
}
