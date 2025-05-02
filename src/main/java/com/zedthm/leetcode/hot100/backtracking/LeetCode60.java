package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/2 14:19
 * @description:
 */
public class LeetCode60 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int k  = Integer.parseInt(br.readLine().trim());
        System.out.println("所有组合: " + new Solution().getPermutation(n, k));
    }
    static class Solution {
        // 预计算阶乘数组优化性能（0!到9!）
        int[] fact = {1,1,2,6,24,120,720,5040,40320,362880};

        public String getPermutation(int n, int k) {
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                nums.add(i);
            }
            StringBuilder res = new StringBuilder();
            backtrack(nums, k, res);
            return res.toString();
        }

        private void backtrack(ArrayList<Integer> nums, int k, StringBuilder res) {
            // 递归终止条件：所有数字都已使用
            if (nums.isEmpty()) {
                return;
            }

            // 计算剩余元素的阶乘数（关键剪枝逻辑）
            int remainFact = fact[nums.size() - 1];
            for (int i = 0; i < nums.size(); i++) {
                // 假设当前已经选择了m个数字，剩余n-m个数字，每个分支对应的排列数是(n-m-1)!。
                // 如果k大于这个数，说明第k个排列不在当前分支，于是跳过该分支，count增加相应的数量，继续处理下一个分支。
                if (k > remainFact) {
                    k-= remainFact;
                    continue;
                }
                // 做选择：将当前数字加入结果
                int num = nums.get(i);
                res.append(num);
                nums.remove(i);  // 从可用列表中移除

                // 递归处理剩余数字（k值不需要修改）
                backtrack(nums, k, res);

                // 注意这里不需要回溯恢复nums和res，因为找到解直接返回
                return;  // 关键点：找到后立即终止后续所有递归
            }
        }


    }
}
