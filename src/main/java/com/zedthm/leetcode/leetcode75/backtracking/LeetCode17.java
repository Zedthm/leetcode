package com.zedthm.leetcode.leetcode75.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/30 15:03
 * @description:
 */
public class LeetCode17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String digits = br.readLine().trim();
        List<String> result = letterCombinations(digits);
    }
    // 记忆要点1：定义全局映射关系
    private static final String[] PHONE_MAP = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };
    //核心三要素：选择列表 → 做出选择 → 撤销选择
    private static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    /**
     * 标准回溯模板结构
     * @param digits   输入数字
     * @param index    当前处理数字索引
     * @param path     当前路径（组合结果）
     * @param result   结果集
     */
    private static void backtrack(String digits, int index,
                                  StringBuilder path, List<String> result) {
        // 终止条件：路径长度等于数字个数
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // 获取当前数字对应的字母
        char num = digits.charAt(index);
        String letters = PHONE_MAP[num - '0'];

        // 遍历所有选择
        for (char letter : letters.toCharArray()) {
            // 做出选择
            path.append(letter);

            // 递归进入下一层决策
            backtrack(digits, index + 1, path, result);

            // 撤销选择（删除最后一个字符）
            path.deleteCharAt(path.length() - 1);
        }
    }

}
