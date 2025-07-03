package com.leetcode75.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 17:19
 * @description:
 */
public class LeetCode605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int n = Integer.parseInt(br.readLine().trim());
    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            // 若无需种花，直接返回true
            if (n == 0) {
                return true;
            }
            int len = flowerbed.length;
            for (int i = 0; i < len; i++) {
                // 只处理空地块（0）
                if (flowerbed[i] == 0) {
                    // 左邻居：首地块左边界视为0，否则取前一位
                    int left = (i == 0) ? 0 : flowerbed[i - 1];
                    // 右邻居：末地块右边界视为0，否则取后一位
                    int right = (i == len - 1) ? 0 : flowerbed[i + 1];

                    // 当左右邻居均为0时，可在当前位置种花
                    if (left == 0 && right == 0) {
                        flowerbed[i] = 1; // 种花
                        n--;              // 剩余花数减1
                        if (n == 0) {     // 若花已种完，提前结束
                            return true;
                        }
                    }
                }
            }
            // 遍历结束但花未种完，返回false
            return false;
        }
    }

    static class Solution2 {
        public boolean canPlaceFlowers(int[] f, int n) {
            int cnt = 0, m = f.length;
            for (int i = 0; i < m; i++) {
                if ((i == 0 || f[i - 1] == 0) && f[i] == 0 && (i == m - 1 || f[i + 1] == 0)) {
                    cnt += 1;
                    f[i] = 1;
                }
            }
            return cnt >= n;
        }
    }
}
