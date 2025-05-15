package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/15 20:15
 * @description:
 */
public class LeetCode200 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine().trim();
            line = line.substring(2, line.length() - 2);
            String[] rows = line.split("\\],\\[");
            char[][] board = new char[rows.length][];
            for (int i = 0; i < rows.length; i++) {
                String[] element = rows[i].split("\", \",");
                board[i] = element[i].toCharArray();
                for (int j = 0; j < element.length; j++) {
                    board[i][j] = element[j].replace("\"", "").charAt(0);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static class Solution {
        public int numIslands(char[][] grid) {
            // 0. 处理空矩阵的特殊情况
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int count = 0; // 岛屿计数器
            // 1. 扫描整个矩阵（大海捞针找陆地）
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    // 2. 发现新陆地（找到未被淹没的'1'）
                    if (grid[row][col] == '1') {
                        count++; // 发现新岛屿
                        dfs(grid, row, col); // 3. 用DFS淹没整个岛屿
                    }
                }
            }
            return count;
        }

        // DFS核心方法：淹没与 (row,col) 相连的所有陆地
        private void dfs(char[][] grid, int row, int col) {
            // 4. 边界检查：确保当前位置在矩阵范围内
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
                return;

            // 5. 终止条件：当前位置是水域或已淹没的陆地
            if (grid[row][col] != '1')
                return;

            // 6. ★★★ 关键操作：淹没当前陆地（标记为已访问） ★★★
            grid[row][col] = '0';

            // 7. 向四个方向扩散（探索相邻区域）
            dfs(grid, row - 1, col); // 上
            dfs(grid, row + 1, col); // 下
            dfs(grid, row, col - 1); // 左
            dfs(grid, row, col + 1); // 右

            // 注意：这里不需要回溯（因为已经永久修改了grid的值）
        }
    }
}
