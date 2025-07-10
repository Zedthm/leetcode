package com.leetcode75.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 12:30
 * @description:
 */
public class LeetCode2215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        line = br.readLine().trim();
        strs = line.split(",");
        int[] arr2 = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr2[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(new Solution().findDifference(arr, arr2));
    }

    static class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            // 1. 转换数组为集合（自动去重）
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int num : nums1) set1.add(num);
            for (int num : nums2) set2.add(num);

            // 2. 找出数组1中独有的元素
            List<Integer> onlyInNums1 = new ArrayList<>();
            for (int num : set1) {
                if (!set2.contains(num)) {
                    onlyInNums1.add(num);
                }
            }

            // 3. 找出数组2中独有的元素
            List<Integer> onlyInNums2 = new ArrayList<>();
            for (int num : set2) {
                if (!set1.contains(num)) {
                    onlyInNums2.add(num);
                }
            }

            // 4. 返回最终结果（包含两个列表的列表）
            List<List<Integer>> answer = new ArrayList<>();
            answer.add(onlyInNums1);
            answer.add(onlyInNums2);
            return answer;
        }
    }
}
