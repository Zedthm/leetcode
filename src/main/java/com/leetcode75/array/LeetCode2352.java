package com.leetcode75.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 13:16
 * @description:
 */
public class LeetCode2352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrayString = line.split("\\],\\[");
        List<int[]> nums = new ArrayList<>();
        for (String s : arrayString) {
            String clean = s.replaceAll("[\\[\\]]", "").trim();
            String[] split = clean.split(",");
            int[] ints = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                ints[i] = Integer.parseInt(split[i]);
            }
            nums.add(ints);
        }
        int[][] arr = new int[nums.size()][];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i);
        }
        System.out.println(new Solution().equalPairs(arr));
    }
    static class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            // 用哈希表存储每一行序列的字符串及出现次数
            Map<String, Integer> rowMap = new HashMap<>();

            // 预处理每一行：转换为逗号分隔的字符串
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(grid[i][j]); // 添加当前元素
                    sb.append(',');        // 添加逗号分隔符
                }
                String rowString = sb.toString();
                rowMap.put(rowString, rowMap.getOrDefault(rowString, 0) + 1);
            }

            int count = 0;
            // 处理每一列：转换为相同格式的字符串并匹配
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(grid[i][j]); // 添加当前元素
                    sb.append(',');        // 添加逗号分隔符（与行一致）
                }
                String colString = sb.toString();
                // 累加匹配的行字符串出现次数
                count += rowMap.getOrDefault(colString, 0);
            }

            return count;
        }
    }
}
