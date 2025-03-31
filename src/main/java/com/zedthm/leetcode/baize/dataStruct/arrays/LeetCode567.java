package com.zedthm.leetcode.baize.dataStruct.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/3/31 16:16
 * @description:
 */
public class LeetCode567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String ss = br.readLine();
        boolean a = checkInclusion1(s, ss);
        boolean b = checkInclusion2(s, ss);
        boolean c = checkInclusion3(s, ss);
        System.out.println(a + " " + b + " " + c);
    }

    private static boolean checkInclusion3(String s, String ss) {
        return false;
    }

    private static boolean checkInclusion2(String s, String ss) {
        int n = s.length() - 1, m = ss.length() - 1;
        if (n > m) {
            return false;
        }
        char[] cnt = new char[26];
        for (int i = 0; i < n; i++) {
            --cnt[s.charAt(i) - 'a'];
            ++cnt[ss.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; i++) {
            int x = ss.charAt(i) - 'a', y = ss.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
        }

        return false;
    }

    private static boolean checkInclusion1(String s, String ss) {
        int n = s.length() - 1, m = ss.length() - 1;
        if (n > m) {
            return false;
        }
        char[] cnt1 = new char[26];
        char[] cnt2 = new char[26];
        for (int i = 0; i < n; i++) {
            ++cnt1[s.charAt(i) - 'a'];
            ++cnt2[ss.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            --cnt2[ss.charAt(i - n) - 'a'];
            ++cnt2[ss.charAt(i) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
