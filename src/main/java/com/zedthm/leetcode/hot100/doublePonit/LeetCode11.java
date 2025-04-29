package com.zedthm.leetcode.hot100.doublePonit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/29 18:38
 * @description:
 */
public class LeetCode11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int result = maxArea(arr);
    }

    private static int maxArea(int[] height) {
        // 边界条件检查
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int left = 0;                       // 左指针初始化
        int right = height.length - 1;      // 右指针初始化

        while (left < right) {
            // 计算当前区域面积
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int area = currentHeight * currentWidth;

            // 更新最大面积
            maxArea = Math.max(maxArea, area);

            // 移动较矮的指针以寻找更大面积的可能性
            if (height[left] < height[right]) {
                left++;  // 左指针右移，尝试寻找更高的左边界
            } else {
                right--; // 右指针左移，尝试寻找更高的右边界
            }
        }

        return maxArea;
    }
}
