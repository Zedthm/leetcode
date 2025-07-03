package com.leetcode75.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 16:53
 * @description:
 */
public class LeetCode1071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine().trim();
        String str2 = br.readLine().trim();

        System.out.println(new Solution().gcdOfStrings(str1, str2));
    }

    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            // 知识点分类：字符串操作、数学（最大公约数）

            // 1. 检查两字符串连接顺序不同时是否相同
            // 思考：这是公因子存在的必要条件（数学特性）
            if (!(str1 + str2).equals(str2 + str1)) {
                return ""; // 不存在公因子
            }

            // 2. 计算两字符串长度的最大公约数 (GCD)
            // 思考：公因子的长度必须是两个长度的公约数
            int gcdLength = gcd(str1.length(), str2.length());

            // 3. 截取最大公约数长度的子串作为候选公因子
            // 注意：由于第一步已验证连接相同，只需截取前缀即可
            return str1.substring(0, gcdLength);
        }

        // 辅助函数：计算最大公约数 (GCD) - 辗转相除法
        // 示例：gcd(12, 8) -> gcd(8,4) -> gcd(4,0) -> 4
        private int gcd(int a, int b) {
            // 当 b=0 时，a 就是最大公约数
            while (b != 0) {
                int temp = b;
                b = a % b; // 求余数
                a = temp;  // 更新被除数
            }
            return a;
        }
    }
}
