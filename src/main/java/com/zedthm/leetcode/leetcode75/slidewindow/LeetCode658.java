package com.zedthm.leetcode.leetcode75.slidewindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/1 15:21
 * @description:
 */
public class LeetCode658 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
    static class Solution {
        /**
         * 标准双指针模板 - 寻找K个最接近元素
         * 时间复杂度：O(log n + k) 空间复杂度：O(1)
         * 核心思想：二分查找定位中间位置 + 双指针扩展
         */
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // 步骤1：二分查找找到最接近x的右边界
            int right = findRightBound(arr, x);
            int left = right - 1;

            // 步骤2：双指针向两边扩展k次
            while (k-- > 0) {
                if (left < 0) {          // 左边界越界，只能向右扩展
                    right++;
                } else if (right >= arr.length) { // 右边界越界，只能向左扩展
                    left--;
                } else if (x - arr[left] <= arr[right] - x) { // 相等时优先选左边
                    left--;
                } else {
                    right++;
                }
            }

            // 步骤3：收集结果（注意左闭右开区间）
            List<Integer> result = new ArrayList<>();
            for (int i = left + 1; i < right; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        /**
         * 二分查找定位右边界（第一个≥x的位置）
         */
        private int findRightBound(int[] arr, int x) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] >= x) {
                    right = mid; // 收缩右边界
                } else {
                    left = mid + 1; // 扩展左边界
                }
            }
            return left; // 结束时left==right
        }
    }
}
