package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/15 22:43
 * @description:
 */
public class LeetCode89 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine().trim();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class Solution {
        List<Integer> result = new ArrayList<>(); // 存储最终结果
        Set<Integer> visited = new HashSet<>(); // 记录已访问的数字
        boolean found = false; // 提前终止回溯的标志

        public List<Integer> grayCode(int n) {
            // 0. 处理n=0的特殊情况
            if (n == 0) {
                return Arrays.asList(0);
            }

            // 1. 初始化路径，从0开始探索
            List<Integer> path = new ArrayList<>();
            path.add(0);
            visited.add(0);

            // 2. 开始回溯搜索
            backtrack(n, path);
            return result;
        }

        // 核心回溯方法（理解这个函数如何生成相邻仅一位不同的序列）
        void backtrack(int n, List<Integer> path) {
            // 3. 终止条件：路径包含所有2ⁿ个数
            if (path.size() == (1 << n)) {
                result = new ArrayList<>(path);
                found = true; // 找到解后立即终止其他递归分支
                return;
            }

            int current = path.get(path.size() - 1); // 取出最后一个数作为当前状态

            // 4. 遍历所有可能的位变化（选择列表）
            for (int i = 0; i < n; i++) {
                // 5. ★★★ 生成下一个候选数（关键操作：异或运算翻转特定位） ★★★
                int next = current ^ (1 << i); // 等价于翻转第i位二进制

                // 6. 剪枝条件：必须满足两个条件
                //    a. 该数字未被使用过
                //    b. 与当前数只有一位不同（由异或运算保证）
                if (!visited.contains(next)) {
                    // 7. 做选择：添加到路径并标记已访问
                    visited.add(next);
                    path.add(next);

                    backtrack(n, path); // 8. 递归处理下一层

                    if (found) {
                        return; // 找到解立即返回
                    }

                    // 9. ★★★ 回溯：撤销选择 ★★★
                    path.remove(path.size() - 1);
                    visited.remove(next);
                }
            }
        }
    }
}
