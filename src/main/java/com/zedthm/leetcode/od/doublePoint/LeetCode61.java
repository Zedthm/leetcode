package com.zedthm.leetcode.od.doublePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/16 13:30
 * @description:
 */
public class LeetCode61 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 读取输入
        String line = br.readLine().trim().replaceAll("[\\[\\]]", "");
        int k = Integer.parseInt(br.readLine().trim());

        // 2. 解析数字数组
        String[] arrStrs = line.split(",");
        int[] nums = new int[arrStrs.length];
        for (int i = 0; i < arrStrs.length; i++) {
            nums[i] = Integer.parseInt(arrStrs[i].trim());
        }

        // 3. 创建链表（修正部分）
        if (nums.length == 0) {
            System.out.println("[]");
            return;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        ListNode result = new Solution().rotateRight(head, k);

        System.out.print("[");
        current = result;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    /**
     * 旋转链表 - 双指针解法
     * 特别为初学者设计，包含详细注释和思考过程
     */
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            // 1. 处理特殊情况：空链表、单节点链表或旋转次数为0
            if (head == null || head.next == null || k == 0) {
                return head; // 直接返回原链表
            }

            // 2. 计算链表长度（第一个指针遍历链表）
            ListNode pointer = head; // 初始化指针
            int length = 1; // 长度计数器（至少有一个节点）

            // 遍历到链表末尾（注意：这里停在最后一个节点，不是null）
            while (pointer.next != null) {
                pointer = pointer.next;
                length++;
            }

            // 3. 计算实际需要旋转的次数（处理k大于链表长度的情况）
            int effectiveK = k % length; // 取模运算避免重复旋转

            // 如果实际不需要旋转
            if (effectiveK == 0) {
                return head;
            }

            // 4. 形成环形链表（将尾节点指向头节点）
            pointer.next = head;

            // 5. 找到新的尾节点（第二个指针移动length-effectiveK-1步）
            int stepsToNewTail = length - effectiveK - 1;
            pointer = head; // 重置指针到头部

            while (stepsToNewTail-- > 0) {
                pointer = pointer.next;
            }

            // 6. 断开环形链表，形成新的链表
            ListNode newHead = pointer.next; // 新头节点
            pointer.next = null; // 断开环

            return newHead;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
