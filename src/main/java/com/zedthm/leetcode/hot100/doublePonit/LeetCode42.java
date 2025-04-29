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

    private static int trap(int[] height) {
        int ans = 0;
        int left =0, right= height.length-1;
        int lmax = 0, rmax=0;
        while (left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);
            if (height[left] < height[right]) {
                ans += lmax - height[left];
                ++left;
            }else{
                ans += rmax - height[right];
                --right;
            }
        }
        return ans;
    }
}
