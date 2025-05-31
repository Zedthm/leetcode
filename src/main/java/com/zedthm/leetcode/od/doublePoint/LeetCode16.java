package com.zedthm.leetcode.od.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/16 12:52
 * @description:
 */
public class LeetCode16 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim().replaceAll("[\\[\\]]","");
        String[] arrStrs = line.split(",");
        int[] nums = new int[arrStrs.length];
        for (int i = 0; i < arrStrs.length; i++) {
            nums[i] = Integer.parseInt(arrStrs[i]);
        }
        int target = Integer.parseInt(br.readLine().trim());
        int i = new Solution().threeSumClosest(nums, target);
        System.out.println(i);
    }
    static class Solution{
        public int threeSumClosest(int[] nums, int target) {
            // 1. 数组排序（双指针前提）
            Arrays.sort(nums);
            int n = nums.length;
            int bestSum = nums[0] + nums[1] + nums[2]; // 初始值

            // 2. 固定第一个数（外层循环）
            for (int i = 0; i < n - 2; i++) {
                // 跳过重复元素（可选）
//                if (i > 0 && nums[i] == nums[i - 1]) {
//                    continue;
//                }

                // 3. 内层双指针：左指针在i+1，右指针在末尾
                int left = i + 1;
                int right = n - 1;

                while (left < right) {
                    // 4. 计算当前三数之和
                    int currentSum = nums[i] + nums[left] + nums[right];

                    // 5. 如果正好等于目标值，直接返回
                    if (currentSum == target) {
                        return target;
                    }

                    // 6. 更新最接近的和
                    if (Math.abs(currentSum - target) < Math.abs(bestSum - target)) {
                        bestSum = currentSum;
                    }

                    // 7. 根据和与目标值的关系移动指针
                    if (currentSum < target) {
                        left++; // 和太小，左指针右移
                    } else {
                        right--; // 和太大，右指针左移
                    }
                }
            }

            return bestSum;
        }
    }
}
