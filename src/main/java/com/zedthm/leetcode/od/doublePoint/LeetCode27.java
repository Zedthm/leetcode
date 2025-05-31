package com.zedthm.leetcode.od.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/16 13:14
 * @description:
 */
public class LeetCode27 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim().replaceAll("[\\[\\]]", "");
        String[] arrStrs = line.split(",");
        int[] nums = new int[arrStrs.length];
        for (int i = 0; i < arrStrs.length; i++) {
            nums[i] = Integer.parseInt(arrStrs[i]);
        }
        int val = Integer.parseInt(br.readLine().trim());
        int result = new Solution().removeElement(nums, val);
        System.out.println(result);
    }
    static class Solution {
        public int removeElement(int[] nums, int val) {
            // 1. 初始化指针：
            // - 慢指针left：记录有效元素的位置（像写作业的笔）
            // - 快指针right：扫描整个数组（像检查作业的眼睛）
            int left = 0;
            int right = nums.length; // 从数组末尾开始

            // 2. 主循环：当两个指针没有相遇时继续
            // 想象成两个人在数组上走路，一个从左，一个从右
            while (left < right) {
                // 3. 检查当前左指针位置的元素
                if (nums[left] == val) {
                    // 情况1：当前元素需要移除

                    // 3.1 把右指针前一个元素复制到左指针位置
                    // 相当于用数组末尾的元素覆盖要删除的元素
                    nums[left] = nums[right - 1];

                    // 3.2 右指针左移（相当于缩小数组范围）
                    // 就像说："这个位置已经处理过了，下次不用看了"
                    right--;

                    // 注意：这里不移动左指针，因为新换过来的元素可能也需要移除
                    // 下次循环会再次检查这个位置
                } else {
                    // 情况2：当前元素可以保留

                    // 4. 左指针右移（保留这个元素，检查下一个位置）
                    // 就像说："这个元素没问题，记下来，看下一个"
                    left++;
                }
            }

            // 5. 循环结束后，left的值就是新数组的长度
            // 所有left左边的元素都是不需要移除的元素
            return left;
        }
    }
}
