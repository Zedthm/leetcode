package com.zedthm.leetcode.hot100.doublePonit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/29 18:52
 * @description:height[left] < height[right] 和 height[left] >= height[right] 的判断，
 * 实际上是维持一个全局最高柱子。最高柱子本身不会影响接水量，接水量仅由较低柱子和较低柱子那一侧的最高柱子决定。
 * 同时，这一侧的最高柱子一定低于全局最高柱子，因此可以保证雨水量计算正确。
 */
public class LeetCode42 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        int result = trap(nums);
        System.out.println(result);
    }

    /**
     * 标准双指针解法 - 接雨水问题
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * 核心策略：双指针夹逼法，动态维护左右边界最大值
     * 算法思想：
     * 1. 左右指针分别从两端向中间移动
     * 2. 动态维护左右两侧遇到的最高柱子（leftMax/rightMax）
     * 3. 当前接水量由较小侧的边界最大值决定
     */
    private static int trap(int[] height) {
        // 边界条件检测：至少需要两根柱子才能储水
        if (height == null || height.length < 2) {
            return 0;
        }

        int water = 0;
        int left = 0;                    // 左指针初始化
        int right = height.length - 1;   // 右指针初始化
        int leftMax = 0;                 // 左侧历史最大高度
        int rightMax = 0;                // 右侧历史最大高度

        while (left < right) {
            // 更新左右侧最大高度（实时维护）
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 核心策略：总是移动高度较小侧的指针
            if (height[left] < height[right]) {
                // 当前左指针处储水量 = 左侧最大高度 - 当前高度
                water += leftMax - height[left];
                left++;
            } else {
                // 当前右指针处储水量 = 右侧最大高度 - 当前高度
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
