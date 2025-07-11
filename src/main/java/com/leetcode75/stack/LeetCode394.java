package com.leetcode75.stack;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 14:14
 * @description:
 */
public class LeetCode394 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        System.out.println(new Solution().decodeString(line));
    }
    static class Solution {
        public String decodeString(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                // 非右括号直接入栈
                if (c != ']') {
                    stack.push(c);
                }
                // 遇到右括号开始解码
                else {
                    // 1. 构建子字符串（反向弹出，正向存储）
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty() && stack.peek() != '[') {
                        sb.append(stack.pop());
                    }
                    String substr = sb.reverse().toString(); // 反转恢复原顺序

                    // 2. 移除左括号
                    stack.pop();

                    // 3. 提取重复次数（考虑多位数字）
                    StringBuilder numStr = new StringBuilder();
                    while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                        numStr.append(stack.pop());
                    }
                    int count = Integer.parseInt(numStr.reverse().toString());

                    // 4. 生成重复字符串
                    StringBuilder repeated = new StringBuilder();
                    for (int i = 0; i < count; i++) {
                        repeated.append(substr);
                    }

                    // 5. 将新字符串重新入栈
                    String newStr = repeated.toString();
                    for (char ch : newStr.toCharArray()) {
                        stack.push(ch);
                    }
                }
            }

            // 构建最终结果（栈中字符顺序反转后拼接）
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            return result.reverse().toString();
        }
    }
}
