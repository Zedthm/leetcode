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
 * @date 2025/5/2 13:45
 * @description:
 */
public class LeetCode40 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        int target = Integer.parseInt(br.readLine().trim());
    }
    static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>  path = new ArrayList<>();
        boolean[] used;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            used = new boolean[candidates.length];
            backtrack(candidates, target, 0, 0);
            return res;
        }

        private void backtrack(int[] nums, int target, int sum, int start) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                sum+=nums[i];
                used[i] = true;
                backtrack(nums, target, sum, i);
                path.remove(path.size() - 1);
                sum -= nums[i];
                used[i] = false;
            }
        }
    }
}
