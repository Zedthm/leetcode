package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/2 14:02
 * @description:
 */
public class LeetCode78 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        List<List<Integer>> result = new Solution().subsets(nums);
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

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0);  // 从第0个元素开始生成子集
            return res;
        }

        // 核心回溯算法
        void backtrack(int[] nums, int start) {
            // 每次递归都记录当前路径（所有节点都是子集）
            res.add(new ArrayList<>(path));  // 深拷贝当前路径

            // 遍历选择列表（关键：从start开始，避免生成重复子集）
            for (int i = start; i < nums.length; i++) {
                // 做选择：将当前数字加入路径
                path.add(nums[i]);

                // 递归处理下一个元素（注意是i+1，不是start+1）
                backtrack(nums, i + 1);

                // 撤销选择：经典回溯操作
                path.remove(path.size() - 1);
            }
        }
    }
}
