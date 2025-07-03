package com.leetcode75.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 18:10
 * @description:
 */
public class LeetCode334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(new Solution().increasingTriplet(nums));
    }
    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            long first = Long.MAX_VALUE;
            long second = Long.MAX_VALUE;
            for (long num : nums) {
                if (num <= first) {
                    first = num;
                }
                else if (num <= second) {
                    second = num;
                }
                else {
                    return true;
                }
            }
            return false;
        }
    }

}
