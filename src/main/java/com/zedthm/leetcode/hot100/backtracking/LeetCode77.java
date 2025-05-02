package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/2 13:50
 * @description:
 */
public class LeetCode77 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());
        System.out.println("所有组合: " +new Solution().combine(n, k));
    }
    static class Solution {
        List<List<Integer>> res = new ArrayList<>();  // 结果集合
        List<Integer> path = new ArrayList<>();        // 当前路径（正在生成的组合）

        public List<List<Integer>> combine(int n, int k) {
            backtrack(n, k, 1);  // 从数字1开始选择
            return res;
        }

        // 核心回溯算法
        void backtrack(int n, int k, int start) {
            // 终止条件：路径长度等于k时，保存结果
            if (path.size() == k) {
                res.add(new ArrayList<>(path));  // 必须创建新对象（重点记忆）
                return;
            }

            /* 遍历选择范围（优化剪枝版）
               原版：i <= n
               优化版：i <= n - (k - path.size()) + 1
               解释：当剩余需要选择的元素数量为 (k - path.size()) 时，
                    最大起始位置是 n - (所需元素数) + 1
                    例如：k=3，已选0个，最多从n-2开始（因为需要连续选3个）
            */
            for (int i = start; i <= n; i++) {
                // 做选择：将当前数字加入路径
                path.add(i);

                // 递归进入下一层（关键点：下一层从i+1开始，避免重复）
                backtrack(n, k, i + 1);

                // 撤销选择：回溯经典操作
                path.remove(path.size() - 1);
            }
        }
    }
}
