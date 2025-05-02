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
 * @date 2025/5/2 14:09
 * @description:
 */
public class LeetCode90 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        List<List<Integer>> result = new Solution().subsetsWithDup(nums);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);  // 关键步骤！必须先排序让相同元素相邻
            used = new boolean[nums.length];
            backtrack(nums, 0);
            return res;
        }

        private void backtrack(int[] nums, int start) {
            // 每次递归都记录当前路径（所有节点都是子集）
            res.add(new ArrayList<>(path));  // 深拷贝当前路径

            for (int i = start; i < nums.length; i++) {
                /* 剪枝条件：处理重复元素
                   条件解释：
                   1. i>0：确保不是第一个元素
                   2. nums[i] == nums[i-1]：当前元素与前一个相同
                   3. !used[i-1]：前一个相同元素未被使用过
                   满足这三个条件时，说明当前分支会产生重复子集，需要跳过
                */
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }

                // 做选择：标记使用并加入路径
                used[i] = true;
                path.add(nums[i]);

                // 递归处理下一个元素（注意是i+1）
                backtrack(nums, i + 1);

                // 撤销选择：经典回溯操作
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
