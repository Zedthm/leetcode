package com.leetcode75.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 18:01
 * @description:
 */
public class LeetCode238 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));
    }
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] answer = new int[n]; // 输出数组

            // 第一步：计算每个元素左侧所有元素的乘积（前缀积）
            answer[0] = 1; // 第一个元素左侧没有元素，默认为1
            for (int i = 1; i < n; i++) {
                // 左侧乘积 = 前一个位置的左侧乘积 × 前一个元素值
                answer[i] = answer[i - 1] * nums[i - 1];
            }

            // 第二步：计算右侧乘积并同步计算最终结果
            int rightProduct = 1; // 动态维护右侧乘积（初始为1）
            for (int i = n - 1; i >= 0; i--) {
                // 当前位置的答案 = 左侧乘积 × 右侧乘积
                answer[i] = answer[i] * rightProduct;
                // 更新右侧乘积（为前一个位置做准备）
                rightProduct *= nums[i];
            }

            return answer;
        }
    }
}
