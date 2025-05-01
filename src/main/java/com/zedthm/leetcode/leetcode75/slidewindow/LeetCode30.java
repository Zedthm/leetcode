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
 * @date 2025/5/1 14:17
 * @description:
 * 外层循环遍历单词长度n的余数，即i从0到n-1。
 * 对于每个i，检查是否存在足够的剩余长度来容纳m*n个字符，否则跳出循环。
 * 初始化一个哈希表differ，记录当前窗口内单词的计数差异。
 * 内层循环首先将前m个单词加入differ，然后减去words中的单词，这样differ中的差异就显示了当前窗口是否匹配。
 * 然后进入滑动窗口循环，移动窗口的起始位置，每次移动一个单词的长度n，更新differ中的计数，并检查是否为空（即匹配成功）。
 */
public class LeetCode30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String line = br.readLine().trim();
        String[] strs = line.replace("\"", "").split(",");
        List<Integer> result = findSubstring(s, strs);
        System.out.println(result);
    }

    /**
     * 标准滑动窗口模板 - 串联所有单词的子串
     * 时间复杂度：O(n * wordLen) 空间复杂度：O(m)
     * 核心思想：分组滑动窗口 + 单词计数匹配
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int totalWords = words.length;
        int wordLen = words[0].length();
        int totalLen = totalWords * wordLen;
        int strLen = s.length();

        // 边界条件处理
        if (strLen < totalLen) {
            return result;
        }

        // 构建目标单词计数表
        Map<String, Integer> targetCounts = new HashMap<>();
        for (String word : words) {
            targetCounts.put(word, targetCounts.getOrDefault(word, 0) + 1);
        }

        // 遍历所有可能的起始偏移（0到wordLen-1）
        // 因为每个可能的起始位置必须满足起始点为i + k*n（k为整数），这样可以覆盖所有可能的起始点而不会重复。
        // 比如偏移量0处理所有起始位置是0,3,6,...的窗口，偏移量1处理1,4,7,...，偏移量2处理2,5,8,...。
        // 这样每个分组内的窗口移动步长是单词长度，这样可以确保覆盖所有可能的起始点，而不会重复检查同一分组内的位置。
        for (int offset = 0; offset < wordLen; offset++) {
            // 当前分组剩余长度不足时提前终止
            if (offset + totalLen > strLen) {
                break;
            }

            // 初始化滑动窗口计数器
            Map<String, Integer> windowCounts = new HashMap<>();
            int validWords = 0; // 有效单词匹配数

            // 滑动窗口主循环
            // 内层循环首先将前m个单词加入differ，然后减去words中的单词，这样differ中的差异就显示了当前窗口是否匹配。
            for (int right = 0; offset + (right + 1) * wordLen <= strLen; right++) {
                // 计算当前右指针位置
                int end = offset + (right + 1) * wordLen;
                int start = end - wordLen;
                String currWord = s.substring(start, end);

                // 添加新单词到窗口
                if (targetCounts.containsKey(currWord)) {
                    windowCounts.put(currWord, windowCounts.getOrDefault(currWord, 0) + 1);
                    if (windowCounts.get(currWord).equals(targetCounts.get(currWord))) {
                        validWords++;
                    }
                }

                // 当窗口超过大小时，移除左侧单词
                if (right >= totalWords) {
                    int leftStart = offset + (right - totalWords) * wordLen;
                    String leftWord = s.substring(leftStart, leftStart + wordLen);
                    if (targetCounts.containsKey(leftWord)) {
                        if (windowCounts.get(leftWord).equals(targetCounts.get(leftWord))) {
                            validWords--;
                        }
                        windowCounts.put(leftWord, windowCounts.get(leftWord) - 1);
                    }
                }

                // 检查是否满足条件
                if (validWords == targetCounts.size()) {
                    result.add(offset + (right - totalWords + 1) * wordLen);
                }
            }
        }
        return result;
    }
}
