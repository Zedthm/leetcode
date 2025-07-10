package com.leetcode75.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 12:39
 * @description:
 */
public class LeetCode1207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(new Solution().uniqueOccurrences(arr));
    }

    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            Set<Integer> unique = new HashSet<>();
            for (Integer i : map.values()) {
                if (unique.contains(i)) {
                    return false;
                } else {
                    unique.add(i);
                }
            }
            return true;
        }
    }
}
