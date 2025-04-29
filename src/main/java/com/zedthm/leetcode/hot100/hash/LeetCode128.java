package com.zedthm.leetcode.hot100.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/29 18:10
 * @description:
 */
public class LeetCode128 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        Integer[] arr = new Integer[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int result = longestConsecutive(arr);
    }

    private static int longestConsecutive(Integer[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (Integer num : nums) {
            numSet.add(num);
        }
        int longestSteak = 0;
        for (Integer i : numSet) {
            if (!numSet.contains(i - 1)) {
                int currentNum = i;
                int currentSteak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentSteak += 1;
                    currentNum += 1;
                }
                longestSteak = Math.max(currentSteak, longestSteak);
            }
        }
        return longestSteak;
    }
}
