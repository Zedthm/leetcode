package com.zedthm.leetcode.leetcode75.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println("所有组合: " + combinationSum3(k, n));
    }

    /**
     * 标准回溯模板 - 组合总和III
     * 时间复杂度：O(C(9,k)) 空间复杂度：O(k)
     * 核心思想：在1-9中找k个不重复数，和为n
     */
    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯核心方法（记忆口诀：选数范围要记清，剪枝条件提前判）
     * @param start    当前选择的起始数字
     * @param remain   剩余需要凑出的和
     * @param need     还需要选择的数字个数
     * @param path     当前路径
     * @param result   结果集
     */
    private static void backtrack(int start, int remain, int need,
                                  List<Integer> path, List<List<Integer>> result) {
        // 剪枝条件1：剩余数字不够选 || 剪枝条件2：和已超目标
        if (need == 0 || remain <= 0) {
            // 终止条件：选够数量且刚好凑出目标
            if (need == 0 && remain == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 遍历选择：从当前数字开始，到9结束
        for (int i = start; i <= 9; i++) {
            // 剪枝条件3：当前数字太大
            if (i > remain) {
                break;
            }

            // 做出选择
            path.add(i);

            // 递归：数字不重复 → i+1，剩余和减少，所需数量减少
            backtrack(i + 1, remain - i, need - 1, path, result);

            // 撤销选择
            path.remove(path.size() - 1);
        }
    }
}