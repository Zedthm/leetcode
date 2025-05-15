package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/15 20:29
 * @description:
 */
public class LeetCode131 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine().trim();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Solution {
        List<List<String>> result = new ArrayList<>(); // 存储所有可能的分割方案
        List<String> path = new ArrayList<>(); // 记录当前路径的分割方式
        boolean[][] isPalindrome; // 预处理数组：isPalindrome[i][j]表示s[i..j]是否是回文

        public List<List<String>> partition(String s) {
            int n = s.length();
            isPalindrome = new boolean[n][n];

            // 1. 预处理阶段：动态规划判断所有子串是否是回文（先理解大框架，细节后面解释）
            for (int i = n-1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (i == j) { // 单字符必定是回文
                        isPalindrome[i][j] = true;
                    } else if (j == i+1) { // 两个字符只需判断相等
                        isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                    } else { // 状态转移：首尾字符相等且内部是回文
                        isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i+1][j-1];
                    }
                }
            }

            // 2. 开始回溯搜索（这是需要重点理解的部分）
            backtrack(s, 0);
            return result;
        }

        // 核心回溯方法（重点理解这个函数的执行流程）
        void backtrack(String s, int startIndex) {
            // 3. 终止条件：已经处理完整个字符串
            if (startIndex == s.length()) {
                result.add(new ArrayList<>(path)); // 深拷贝当前路径
                return;
            }

            // 4. 遍历所有可能的结束位置（从startIndex到字符串末尾）
            for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
                // 5. 剪枝条件：当前子串不是回文就跳过（通过预处理数组快速判断）
                if (!isPalindrome[startIndex][endIndex]) {
                    continue;
                }

                // 6. 做选择：将s[start..end]加入当前路径
                path.add(s.substring(startIndex, endIndex+1));

                // 7. 递归处理剩余部分（关键理解这里传的是endIndex+1）
                backtrack(s, endIndex + 1);

                // 8. ★★★ 回溯：撤销选择（重点理解为什么要remove） ★★★
                path.remove(path.size() - 1);
            }
        }
    }
}
