package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/2 13:10
 * @description:
 */
public class LeetCode46 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        List<List<Integer>> result = new Solution().permute(nums);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        // 最终结果集合
        List<List<Integer>> res = new ArrayList<>();
        // 当前路径集合（用于保存当前递归路径）
        List<Integer> path = new ArrayList<>();
        // 标记数组元素是否被使用过（用于避免重复选择）
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];  // 初始化标记数组
            backtrack(nums);                  // 开始回溯
            return res;
        }

        // 核心回溯算法
        // 做选择→递归→撤销选择
        void backtrack(int[] nums) {
            // 终止条件：当路径长度等于数组长度时，说明找到一个排列
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));  // 深拷贝当前路径加入结果集
                return;
            }

            // 遍历所有可能的选项
            // 每一层选择一个未被使用的数字，直到选满所有数字
            for (int i = 0; i < nums.length; i++) {
                // 跳过已经被使用的元素（关键剪枝操作）
                if (used[i]) {
                    continue;
                }

                // 做选择：将当前数字加入路径，并标记为已使用
                path.add(nums[i]);
                used[i] = true;

                // 进入下一层决策树（递归）
                backtrack(nums);

                // 撤销选择：将当前数字移出路径，并标记为未使用（回溯核心）
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
