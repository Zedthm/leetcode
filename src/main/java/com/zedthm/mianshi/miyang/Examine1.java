package com.zedthm.mianshi.miyang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/3/31 21:13
 * @description:
 */
public class Examine1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            System.out.println(rabbitNums(n));
        }
//        int n = Integer.parseInt(br.readLine().trim());
//        long result = rabbitNums(n);
//        System.out.println(result);
    }

    private static long rabbitNums(int n) {
        if (n < 1) {
            return 1;
        }
        // 记录每个年龄段兔子数量，数组下标从零开始
        int[] curAges = new int[12];
        curAges[0] = 1;

        // 遍历日期
        for (int month = 1; month <= n; month++) {

            // 记录新生儿数量，注意 i = 2，数组下标从0开始，大于3个月才能生
            int born = 0;
            for (int i = 2; i < 12; i++) {
                born += curAges[i];
            }

            // 使用临时数组变量，更新兔子年龄段，年龄大于12死亡
            int[] nextAges = new int[12];
            for (int i = 0; i < 12; i++) {
                if (i + 1 < 12) {
                    nextAges[i + 1] = curAges[i];
                }
            }

            // 维护年龄段数组
            nextAges[0] = born;
            curAges = nextAges;
        }
        long total = 0;
        for (int i : curAges) {
            total+=i;
        }
        return total;
    }
}
