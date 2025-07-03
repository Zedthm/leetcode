package com.leetcode75.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 18:55
 * @description:
 */
public class LeetCode283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            // 慢指针：记录非零元素存放位置
            int slow = 0;

            // 快指针遍历数组
            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] != 0) {
                    // 非零元素前移到慢指针位置
                    nums[slow] = nums[fast];
                    // 慢指针后移
                    slow++;
                }
            }

            // 填充剩余位置为零
            while (slow < nums.length) {
                nums[slow] = 0;
                slow++;
            }
        }
    }
}
