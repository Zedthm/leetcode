package com.zedthm.leetcode.leetcode75.slidewindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/1 12:59
 * @description:
 */
public class LeetCode219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int k = Integer.parseInt(br.readLine().trim());
        String[] arrStr = line.split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        boolean result = containsNearbyDuplicate(nums, k);
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (hash.containsKey(n) && i - hash.get(n) <= k) {
                return true;
            }
            hash.put(n, i);
        }
        return false;
    }
}
