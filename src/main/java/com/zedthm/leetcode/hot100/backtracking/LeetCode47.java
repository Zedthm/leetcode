package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/2 13:23
 * @description:
 */
public class LeetCode47 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        List<List<Integer>> result = new Solution().permuteUnique(nums);

    }

    static class Solution {
        // 最终结果集合
        List<List<Integer>> res = new ArrayList<>();
        // 当前路径集合（用于保存当前递归路径）
        List<Integer> path = new ArrayList<>();
        // 标记数组元素是否被使用过（用于避免重复选择）
        boolean[] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);  // 关键步骤！必须先排序让相同元素相邻
            used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        void backtrack(int[] nums) {
            // 终止条件：路径长度等于数组长度时，找到一个合法排列
            if (path.size() == nums.length) {
                // 回溯算法中会不断地修改path，最终当所有递归完成时，path会被清空，所以res中的所有元素其实都指向同一个空列表。
                res.add(new ArrayList<>(path));  // 深拷贝当前路径加入结果集
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 情况1：当前元素已被使用（剪枝）
                if (used[i]) {
                    continue;
                }

                /* 关键剪枝逻辑（处理重复元素）
                   条件解释：
                   1. i>0：确保不是第一个元素
                   2. nums[i] == nums[i-1]：当前元素与前一个相同
                   3. !used[i-1]：前一个相同元素未被使用过
                   满足这三个条件时，说明当前分支会产生重复排列，需要跳过
                */
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }

                // 做选择：加入路径并标记
                path.add(nums[i]);
                used[i] = true;

                // 递归进入下一层决策树
                backtrack(nums);

                // 撤销选择：回溯核心操作
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
