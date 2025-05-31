package com.zedthm.leetcode.od.slashWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/17 17:33
 * @description:
 */
public class LeetCode76 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String s = br.readLine().trim();
        String t = br.readLine().trim();

    }

    static class Solution {
        public String minWindow(String s, String t) {
            int[] target = new int[128];
            for (char c : t.toCharArray()) {
                target[c]++;
            }
            int left = 0, right = 0;
            int matched = 0;
            int minLen = Integer.MAX_VALUE;
            int minStart = 0;
            while (right < s.length()) {
                char rc = s.charAt(right);
                right++;
                if (--target[rc] >= 0) {
                    matched++;
                }
                while (matched == t.length()) {
                    if (right - left < minLen) {
                        minLen = right - left;
                        minStart = left;
                    }
                    char lc = s.charAt(left);
                    left++;
                    if (++target[lc] > 0) {
                        matched--;
                    }
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }
    }
}
