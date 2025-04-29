package com.zedthm.leetcode.hot100.doublePonit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/29 18:43
 * @description:
 */
public class LeetCode15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        List<List<Integer>> result = threeSum(arr);
    }

    /**
     * 标准双指针解法 - 三数之和
     * 时间复杂度：O(n²)  空间复杂度：O(log n) 排序所需
     * 核心策略：排序 + 双指针 + 去重剪枝
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 边界条件检查
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 步骤1：排序数组（双指针前置条件）
        Arrays.sort(nums);
        int n = nums.length;

        // 步骤2：遍历第一个元素
        for (int i = 0; i < n - 2; i++) {
            // 剪枝1：跳过重复的第一个元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 剪枝2：提前终止不可能的情况
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) {
                continue;
            }

            // 步骤3：初始化双指针
            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];

            // 步骤4：双指针扫描
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 移动指针并跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;  // 和过小，左指针右移
                } else {
                    right--; // 和过大，右指针左移
                }
            }
        }
        return result;
    }
}
