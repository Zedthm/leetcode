package com.zedthm.leetcode.leetcode75.slidewindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/1 12:52
 * @description:
 */
public class LeetCode187 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        List<String> result = findRepeatedDnaSequences(line);
    }

    private static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String str = s.substring(i, i + 10);
            cnt.put(str, cnt.getOrDefault(str, 0) + 1);
            if (cnt.get(str) == 2) {
                ans.add(str);
            }
        }
        return ans;
    }
}
