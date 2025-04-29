package com.zedthm.leetcode.hot100.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/29 17:58
 * @description:
 */
public class LeetCode49 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = hash.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            hash.put(key, list);
        }
        return new ArrayList<List<String>>(hash.values());
    }

    private static List<List<String>> groupAnagrams_2(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a'] ++;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }

            String key = sb.toString();
            List<String> list = hash.getOrDefault(key, new ArrayList<>());
            list.add(str);
            hash.put(key, list);
        }
        return new ArrayList<>(hash.values());
    }
}
