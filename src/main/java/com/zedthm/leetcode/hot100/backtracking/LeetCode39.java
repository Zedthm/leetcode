package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/2 13:35
 * @description:
 * 终止条件、遍历选择、做出选择与撤销选择
 */
public class LeetCode39 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        int target = Integer.parseInt(br.readLine().trim());
        System.out.println(new Solution().combinationSum(nums, target));
    }
    static class Solution {
        List<List<Integer>> res = new ArrayList<>();  // 存放结果集
        List<Integer> path = new ArrayList<>();       // 当前组合路径

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(candidates, target, 0, 0);      // 从第0个元素开始，初始和为0
            return res;
        }

        // 回溯核心方法
        // start：控制选择起点（关键去重）
        // sum：当前路径的元素和
        void backtrack(int[] nums, int target, int sum, int start) {
            // 终止条件1：当前和等于目标值
            if (sum == target) {
                res.add(new ArrayList<>(path));  // 必须创建新集合（重点记忆）
                return;
            }
            // 终止条件2：当前和超过目标值
            if (sum > target) {
                return;
            }

            // 遍历选择列表（关键设计：i从start开始）
            for (int i = start; i < nums.length; i++) {
                // 做选择：更新路径和总和
                path.add(nums[i]);
                sum += nums[i];

                // 递归：注意这里传i而不是i+1，允许重复选当前元素
                backtrack(nums, target, sum, i);

                // 撤销选择：回溯经典操作
                path.remove(path.size() - 1);
                sum -= nums[i];
            }
        }
    }
}
