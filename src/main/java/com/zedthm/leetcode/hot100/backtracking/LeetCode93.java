package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/2 14:39
 * @description:
 */
public class LeetCode93 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        new Solution().restoreIpAddresses(line);
    }
    static class Solution {
        List<String> res = new ArrayList<>();  // 存储结果
        List<String> path = new ArrayList<>(); // 当前路径（存放IP段）

        public List<String> restoreIpAddresses(String s) {
            // 快速排除不可能的情况（IP地址总长度4~12）
            if (s.length() < 4 || s.length() > 12) {
                return res;
            }
            backtrack(s, 0, 0);
            return res;
        }

        /**
         * 回溯核心方法
         * @param s 原始字符串
         * @param start 当前处理字符起始位置
         * @param segCount 已分割的段数（范围0~4）
         */
        void backtrack(String s, int start, int segCount) {
            // 终止条件：分割完成四段
            if (segCount == 4) {
                // 必须刚好用完所有字符
                if (start == s.length()) {
                    res.add(String.join(".", path)); // 拼接IP地址
                }
                return;
            }

            // 尝试截取1~3位字符（剪枝：剩余字符数不够时提前终止）
            for (int len = 1; len <= 3; len++) {
                // 剩余字符数不足时跳出循环（剪枝）
                if (start + len > s.length()) {
                    break;
                }

                // 处理前导零问题（长度超过1的段不能以0开头）
                String segment = s.substring(start, start + len);
                if (segment.startsWith("0") && segment.length() > 1) {
                    continue;
                }

                // 检查数值是否合法（0~255）
                int value = Integer.parseInt(segment);
                if (value > 255) {
                    continue;
                }

                // 做选择：将该段加入路径
                path.add(segment);

                // 递归处理下一段
                backtrack(s, start + len, segCount + 1);

                // 撤销选择（回溯）
                path.remove(path.size() - 1);
            }
        }
    }
}
