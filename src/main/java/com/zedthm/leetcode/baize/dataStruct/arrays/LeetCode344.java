package com.zedthm.leetcode.baize.dataStruct.arrays;

import java.util.*;
import java.io.*;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/3/31 15:59
 * @description:
 */
public class LeetCode344 {
    public static void main(String[] args) throws IOException {
        //1. 创建高效缓冲流读取器
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //2. 读取输入行
        String line;
        while ((line = br.readLine()) != null) {
            line  = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            char[] s = line.toCharArray();
            reverseString(s);
            System.out.println(new String(s));
        }

    }

    private static void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        for (; left < right; ++left, --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
