package com.leetcode75.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 12:23
 * @description:
 */
public class LeetCode1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(new Solution().findMiddleIndex(arr));
    }

    static class Solution {
        public int findMiddleIndex(int[] nums) {
            int total = 0;
            for (int num : nums) {
                total += num;
            }
            int leftSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (2 * leftSum + nums[i] == total) {
                    return i;
                }
                leftSum += nums[i];
            }
            return -1;
        }
    }
}
