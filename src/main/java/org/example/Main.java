package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. 创建高效缓冲流读取器
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //2. 读取输入行（按需选择）
        String input = br.readLine().trim();
        String[] parts = input.split(" ");

        String[] strNums = br.readLine().trim().split("\\s+");
        int[] nums = new int[strNums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }

        int rows = Integer.parseInt(br.readLine());
        char[][] grid = new char[rows][];
        for (int i = 0; i < rows; i++) {
            grid[i] = br.readLine().trim().toCharArray();
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String data = br.readLine().trim();
        }
        System.out.println("Hello world!");
    }
}