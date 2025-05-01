package com.zedthm.leetcode.leetcode75.slidewindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/1 15:46
 * @description:
 * 窗口初始状态：left=0, right=0 → [0]
 * 窗口扩展过程：
 * right=0 → 覆盖组1 → groupsCovered=1
 * right=1 → 覆盖组0 → groupsCovered=2
 * right=2 → 覆盖组2 → groupsCovered=3（满足条件）
 * 此时开始收缩左边界：
 *    计算长度0-5=5 → 记录结果[0,5]
 *    left右移至1 → 窗口变为[4,0], [5,2] → 仍覆盖所有组
 *    更新最小长度5-4=1 → 结果更新为[4,5]
 * 继续收缩直到不满足覆盖条件
 */
public class LeetCode632 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    static class SmallestRange {
        /**
         * 查找覆盖所有列表至少一个元素的最小区间
         *
         * @param nums 包含多个有序列表的集合
         * @return 最小区间的起止值数组
         */
        public int[] smallestRange(List<List<Integer>> nums) {
            /*----- 步骤1：合并所有元素并记录所属组号 -----*/
            List<int[]> elements = new ArrayList<>(); // 结构：[元素值, 所属组编号]
            for (int groupId = 0; groupId < nums.size(); groupId++) {
                // 遍历当前组的每个元素，记录值和组号
                for (int num : nums.get(groupId)) {
                    elements.add(new int[]{num, groupId});
                }
            }

            /*----- 步骤2：按元素值升序排序（滑动窗口前置条件）-----*/
            //将元素按值排序后，保证滑动窗口的数值连续性，直接通过首尾差值计算区间长度
            Collections.sort(elements, (a, b) -> a[0] - b[0]); // 按数值从小到大排序

            /*----- 步骤3：滑动窗口寻找覆盖所有组的最小区间 -----*/
            int[] count = new int[nums.size()];      // 记录各组的元素出现次数
            //通过count[]数组精确跟踪各组覆盖状态，避免重复扫描
            int groupsCovered = 0;                   // 当前窗口覆盖的组数量
            int minLen = Integer.MAX_VALUE;          // 记录最小窗口长度
            int[] result = new int[2];               // 存储最终结果
            int left = 0;                            // 滑动窗口左指针

            // 右指针遍历所有元素（窗口右扩）
            for (int right = 0; right < elements.size(); right++) {
                // 获取当前右指针元素的组号
                int groupId = elements.get(right)[1];

                // 更新当前组的计数：首次出现则增加覆盖组数
                if (count[groupId] == 0) {
                    groupsCovered++;
                }
                count[groupId]++; // 增加该组的元素计数

                /*-- 当窗口覆盖所有组时，尝试收缩左边界寻找最优解 --*/
                while (groupsCovered == nums.size()) {
                    // 计算当前窗口长度（排序后可直接用首尾差值）
                    int currentLen = elements.get(right)[0] - elements.get(left)[0];

                    // 发现更小区间或等长但起始更小的情况则更新结果
                    if (currentLen < minLen ||
                            (currentLen == minLen && elements.get(left)[0] < result[0])) {
                        minLen = currentLen;
                        result[0] = elements.get(left)[0]; // 窗口左端值
                        result[1] = elements.get(right)[0]; // 窗口右端值
                    }

                    // 获取左指针元素的组号，准备左移
                    int leftGroup = elements.get(left)[1];

                    // 减少该组的计数，若归零则减少覆盖组数
                    count[leftGroup]--;
                    if (count[leftGroup] == 0) {
                        groupsCovered--;
                    }

                    left++; // 左指针右移（收缩窗口）
                }
            }

            return result;
        }
    }
}
