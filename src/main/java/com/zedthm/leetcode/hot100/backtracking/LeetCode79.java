package com.zedthm.leetcode.hot100.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/15 19:47
 * @description:
 */
public class LeetCode79 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine().trim();
            line = line.substring(2, line.length() - 2);
            String[] rows = line.split("\\],\\[");
            char[][] board = new char[rows.length][];
            for (int i = 0; i < rows.length; i++) {
                String[] element = rows[i].split("\", \"");
                board[i] = new char[element.length];
                for (int j = 0; j < element.length; j++) {
                    board[i][j] = element[j].replace("\"", "").charAt(0);
                }
            }
            String word = br.readLine().trim().replace("\"", "");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            // 1. 遍历每个起点：矩阵中每个点都可能是起点
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 2. 从当前点开始搜索，初始检查第0个字符
                    if (dfs(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
            return false;
        }

        // 核心DFS回溯方法（重点理解每一步的判断）
        private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
            // 3. 【终止条件1】当前字符不匹配，立刻返回false（剪枝）
            if (board[i][j] != word.charAt(index)) {
                return false;
            }
            // 4. 【终止条件2】已经匹配完所有字符，返回true
            if (index == word.length() - 1) {
                return true;
            }

            // 5. 标记当前点已访问（防止回头）
            visited[i][j] = true;

            // 6. 定义四个方向：右下左上（顺序不影响结果）
            int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

            // 7. 尝试所有可能方向（这是回溯的关键）
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                // 8. 剪枝条件：新坐标在矩阵内 且 未被访问过
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                    // 9. 递归深入：检查下一个字符
                    if (dfs(board, x, y, word, index + 1, visited)) {
                        return true; // 找到完整路径立即返回，不再尝试其他方向
                    }
                }
            }

            // 10. ★★★ 回溯关键步骤：撤销当前点的访问标记 ★★★
            visited[i][j] = false;

            return false;
        }
    }
}
