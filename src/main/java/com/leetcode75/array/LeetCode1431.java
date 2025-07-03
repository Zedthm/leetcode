package com.leetcode75.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 17:01
 * @description:
 */
public class LeetCode1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int k = Integer.parseInt(br.readLine().trim());
    }
    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            // 知识点分类：数组遍历、简单逻辑判断

            // 1. 先找到当前最大糖果数量
            int maxCandies = findMax(candies);

            // 2. 创建结果列表
            List<Boolean> result = new ArrayList<>();

            // 3. 检查每个孩子加上额外糖果后是否能成为最多
            for (int i = 0; i < candies.length; i++) {
                // 关键思考：当前糖果 + 额外糖果 ≥ 最大值 = 能成为最多（或并列）
                result.add(candies[i] + extraCandies >= maxCandies);
            }

            return result;
        }

        // 辅助函数：找数组最大值
        private int findMax(int[] arr) {
            int max = arr[0];
            // 遍历找到最大糖果数量
            for (int candy : arr) {
                if (candy > max) {
                    max = candy;
                }
            }
            return max;
        }
    }
}
