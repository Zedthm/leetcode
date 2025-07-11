package com.leetcode75.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/7/10 13:57
 * @description:
 */
public class LeetCode735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int[] ints = new Solution().asteroidCollision(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<>();  // 用栈模拟行星序列

            for (int ast : asteroids) {
                if (ast > 0) {  // 当前行星向右：直接入栈
                    stack.push(ast);
                } else {  // 当前行星向左：可能与栈顶向右行星碰撞
                    // 循环判断：当前行星未炸且栈顶行星向右且可以碰撞
                    while (!stack.isEmpty() && stack.peek() > 0 && -ast > stack.peek()) {
                        stack.pop();  // 栈顶行星炸掉（比当前小）
                    }

                    if (!stack.isEmpty() && stack.peek() == -ast) {  // 大小相等
                        stack.pop();  // 栈顶行星炸掉
                    } else if (stack.isEmpty() || stack.peek() < 0) {  // 没有可碰撞的行星
                        stack.push(ast);  // 当前行星入栈
                    }
                    // 其余情况：栈顶行星比当前大，当前行星直接炸掉（不操作）
                }
            }

            // 将栈中行星按顺序输出（从栈底到栈顶）
            int[] result = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return result;
        }
    }
}
