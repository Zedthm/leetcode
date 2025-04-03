package com.zedthm.leetcode.baize.dataStruct.linkList;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/1 22:52
 * @description:
 */
public class LeetCode141 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(ListNode node) {
            this.next = node;
        }

        public ListNode() {
        }
    }

    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
