package com.zedthm.leetcode.leetcode75.dp_single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/30 14:43
 * @description:
 */
public class LeetCode198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        int result = rob(nums);
    }

    /**
     * 标准动态规划模板 - 打家劫舍
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * 核心思想：
     * 1. 每个房屋有两种选择：抢劫（取前前房屋的累计值）或不抢劫（取前房屋的累计值）
     * 2. 状态转移方程：dp[i] = max(抢劫当前房屋, 不抢劫当前房屋)
     * 3. 可优化至O(1)空间复杂度
     */
    private static int rob(int[] nums) {
        // 边界条件处理
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] maxRobbedAmount = new int[n]; // dp数组更明确的命名

        // 初始化基准状态
        maxRobbedAmount[0] = nums[0];
        maxRobbedAmount[1] = Math.max(nums[0], nums[1]);

        // 状态转移填表
        for (int i = 2; i < n; i++) {
            maxRobbedAmount[i] = Math.max(
                    maxRobbedAmount[i-1],       // 不抢劫当前房屋
                    maxRobbedAmount[i-2] + nums[i] // 抢劫当前房屋
            );
        }
        return maxRobbedAmount[n-1];
    }
}
