package com.leetcode75.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/2 17:23
 * @description:
 */
public class LeetCode345 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        System.out.println(new Solution().reverseVowels(s));
    }
    static class Solution {
        public String reverseVowels(String s) {
            // 所有元音字母（大小写）
            String vowels = "aeiouAEIOU";

            // 字符串转字符数组（Java字符串不可变）
            char[] chars = s.toCharArray();

            // 双指针初始化
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                // 左指针：找到元音字母（非元音则右移）
                while (left < right && vowels.indexOf(chars[left]) == -1) {
                    left++;
                }
                // 右指针：找到元音字母（非元音则左移）
                while (left < right && vowels.indexOf(chars[right]) == -1) {
                    right--;
                }

                // 交换两个元音字母
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                // 双指针向中间移动
                left++;
                right--;
            }

            // 字符数组转字符串
            return new String(chars);
        }
    }
}
