package com.zedthm.leetcode.baize.dataStruct.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/3/31 16:16
 * @description:
 */
public class LeetCode567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String ss = br.readLine();
        boolean a = checkInclusion1(s, ss);
        boolean b = checkInclusion2(s, ss);
        boolean c = checkInclusion3(s, ss);
        System.out.println(a + " " + b + " " + c);
    }

    private static boolean checkInclusion3(String s1, String s2) {
        // 步骤1：预处理长度和数组
        int n = s1.length(), m = s2.length();
        if(n > m) return false;               // 边界：s1比s2长直接失败
        int[] cnt = new int[26];              // 用数组代替哈希表（仅小写字母）

        // 步骤2：初始化s1的"欠债表"
        for(int i=0; i<n; i++){
            --cnt[s1.charAt(i)-'a'];          // 负数表示s1欠这些字符
        }

        // 步骤3：滑动窗口还债
        int left=0;
        for(int right=0; right<m; right++){
            int x = s2.charAt(right)-'a';
            ++cnt[x];                         // 右指针：将字符加入窗口
            while(cnt[x] > 0){                // 关键：当前字符超额了！
                --cnt[s2.charAt(left)-'a'];   // 左指针：吐出最左侧字符
                left++;                       // 左移直到不超额
            }
            if(right-left+1 == n) return true; // 窗口长度正好是n，成功！
        }
        return false;
    }

    private static boolean checkInclusion2(String s, String ss) {
        int n = s.length() - 1, m = ss.length() - 1;
        if (n > m) {
            return false;
        }
        char[] cnt = new char[26];
        for (int i = 0; i < n; i++) {
            --cnt[s.charAt(i) - 'a'];
            ++cnt[ss.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; i++) {
            int x = ss.charAt(i) - 'a', y = ss.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
        }

        return false;
    }

    private static boolean checkInclusion1(String s, String ss) {
        int n = s.length() - 1, m = ss.length() - 1;
        if (n > m) {
            return false;
        }
        char[] cnt1 = new char[26];
        char[] cnt2 = new char[26];
        for (int i = 0; i < n; i++) {
            ++cnt1[s.charAt(i) - 'a'];
            ++cnt2[ss.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        // 步骤3：滑动窗口比较后续字符
        for (int i = n; i < m; ++i) {           // 窗口右移，i为新字符位置
            ++cnt2[ss.charAt(i) - 'a'];          // 新字符加入窗口右侧
            --cnt2[ss.charAt(i - n) - 'a'];     // 旧字符移出窗口左侧
            if (Arrays.equals(cnt1, cnt2)) {
                return true; // 每次滑动后立即检查
            }
        }
        return false;
    }
}
