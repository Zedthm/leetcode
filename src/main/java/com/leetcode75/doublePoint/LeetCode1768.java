package com.leetcode75.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 16:30
 * @description:
 */
public class LeetCode1768 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine().trim();
        String str2 = br.readLine().trim();
        System.out.println(new Solution().mergeAlternately(str1, str2));
    }

    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            // 知识点分类：字符串操作、双指针、循环控制

            // 0. 用 StringBuilder 高效拼接字符串（比直接操作字符串更快）
            StringBuilder result = new StringBuilder();

            // 1. 获取两个字符串的长度
            int len1 = word1.length();
            int len2 = word2.length();

            // 2. 定义双指针分别遍历 word1 和 word2
            int i = 0, j = 0;

            // 3. 交替合并核心逻辑：
            //    - 只要任一字符串还有字符就继续合并
            //    - 通过布尔变量控制交替顺序（true 取 word1，false 取 word2）
            boolean flag = true; // 初始从 word1 开始
            while (i < len1 || j < len2) {
                // 当 flag=true 且 word1 还有字符时，取 word1
                if (flag && i < len1) {
                    result.append(word1.charAt(i));
                    i++;      // 移动 word1 指针
                }
                // 当 flag=false 且 word2 还有字符时，取 word2
                else if (!flag && j < len2) {
                    result.append(word2.charAt(j));
                    j++;      // 移动 word2 指针
                }
                // 切换交替标记（true↔false）
                flag = !flag;

            /* 关键思考：当应该取的字符串已用完时（例如轮到 word1 但 i>=len1）
               不操作字符，直接切换 flag，下一轮就会取另一个字符串
               这样实现了自动跳过空字符串，继续合并剩余部分 */
            }

            // 4. 返回最终合并结果
            return result.toString();
        }
    }
}
