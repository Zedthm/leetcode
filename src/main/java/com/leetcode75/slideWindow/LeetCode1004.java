package com.leetcode75.slideWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/4 13:51
 * @description:
 */
public class LeetCode1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int k = Integer.parseInt(br.readLine().trim());
        System.out.println(new Solution().longestOnes(arr, k));
    }
    static class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0;      // 窗口左指针
            int zeroCount = 0; // 当前窗口中0的数量
            int maxLength = 0; // 记录最大窗口长度（即最大连续1的长度）

            // 1. 右指针遍历数组
            for (int right = 0; right < nums.length; right++) {
                // 2. 遇到0时增加计数器
                if (nums[right] == 0) {
                    zeroCount++;
                }

                // 3. 如果0的数量超过K，移动左指针直到移除一个0
                while (zeroCount > k) {
                    if (nums[left] == 0) {
                        zeroCount--;
                    }
                    left++;
                }

                // 4. 更新最大窗口长度
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }
}
