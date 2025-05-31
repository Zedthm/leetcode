package com.zedthm.leetcode.od.slashWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/17 17:40
 * @description:
 */
public class LeetCode438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String p = br.readLine().trim();

    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            int slen = s.length(), plen = p.length();
            if (slen < plen) {
                return result;
            }
            int[] pCount = new int[26];
            int[] sCount = new int[26];

            for (int i = 0; i < plen; i++) {
                pCount[p.charAt(i) - 'a']++;
                sCount[s.charAt(i) - 'a']++;
            }

            if (Arrays.equals(pCount, sCount)) {
                result.add(0);
            }

            for (int i = plen; i < slen; i++) {
                char leftChar = s.charAt(i - plen);
                sCount[leftChar - 'a']--;
                char rightChar = s.charAt(i);
                sCount[rightChar - 'a']++;
                if (Arrays.equals(sCount, pCount)) {
                    result.add(i - plen + 1);
                }
            }
            return result;
        }
    }
}
