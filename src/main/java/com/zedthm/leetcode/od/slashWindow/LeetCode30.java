package com.zedthm.leetcode.od.slashWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/16 15:31
 * @description:
 */
public class LeetCode30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        String line = br.readLine().trim().replaceAll("[\\[\\]]", "");
        String[] strs = line.replaceAll("[\"\"]", "").split(",");
        List<Integer> substring = new Solution().findSubstring(str, strs);
    }

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();

            // 1. 处理边界情况
            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return result;
            }

            // 2. 计算基本参数
            int wordLen = words[0].length();    // 每个单词的长度
            int totalWords = words.length;      // 单词总数
            int windowLen = wordLen * totalWords; // 窗口总长度
            int strLen = s.length();            // 字符串总长度

            // 3. 检查字符串长度是否足够
            if (strLen < windowLen) {
                return result;
            }

            // 4. 创建目标单词频率表（需要匹配的单词和出现次数）
            Map<String, Integer> targetMap = new HashMap<>();
            for (String word : words) {
                targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);
            }

            // 5. 滑动窗口主循环
            // 因为单词是固定长度，所以需要考虑不同的起始偏移量(0到wordLen-1)
            for (int offset = 0; offset < wordLen; offset++) {
                // 当前偏移量下剩余长度不足时跳过
                if (offset + windowLen > strLen) {
                    continue;
                }

                // 创建窗口内的单词频率表
                Map<String, Integer> windowMap = new HashMap<>();
                int matchedWords = 0; // 已匹配的单词数

                // 滑动窗口移动（每次移动一个单词的长度）
                for (int right = 0; offset + (right + 1) * wordLen <= strLen; right++) {
                    // 5.1 获取当前单词
                    int start = offset + right * wordLen;
                    int end = start + wordLen;
                    String currWord = s.substring(start, end);

                    // 5.2 如果当前单词是需要匹配的单词
                    if (targetMap.containsKey(currWord)) {
                        // 添加到窗口频率表
                        windowMap.put(currWord, windowMap.getOrDefault(currWord, 0) + 1);

                        // 检查是否完全匹配了该单词的需求数量
                        if (windowMap.get(currWord).equals(targetMap.get(currWord))) {
                            matchedWords++;
                        }
                    }

                    // 5.3 当窗口达到规定大小时，开始移除左侧单词
                    if (right >= totalWords) {
                        int leftStart = offset + (right - totalWords) * wordLen;
                        String leftWord = s.substring(leftStart, leftStart + wordLen);

                        if (targetMap.containsKey(leftWord)) {
                            // 如果移除前刚好匹配，现在不匹配了
                            if (windowMap.get(leftWord).equals(targetMap.get(leftWord))) {
                                matchedWords--;
                            }
                            // 从窗口频率表中移除该单词
                            windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        }
                    }

                    // 5.4 检查是否所有单词都完美匹配
                    if (matchedWords == targetMap.size()) {
                        // 计算匹配的起始位置并加入结果
                        int matchStart = offset + (right - totalWords + 1) * wordLen;
                        result.add(matchStart);
                    }
                }
            }

            return result;
        }
    }
}
