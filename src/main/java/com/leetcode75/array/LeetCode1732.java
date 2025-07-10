package com.leetcode75.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 12:09
 * @description:
 */
public class LeetCode1732 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(new Solution().largestAltitude(arr));
    }

    static class Solution {
        public int largestAltitude(int[] gain) {
            int curHeight = 0;
            int maxHeight = 0;
            for (int i = 0; i < gain.length; i++) {
                curHeight += gain[i];
                maxHeight = Math.max(maxHeight, curHeight);
            }
            return maxHeight;
        }
    }
}
