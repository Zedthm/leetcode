package com.zedthm.leetcode.springPrint.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Queue;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/31 15:33
 * @description:
 */
public class LeetCode100 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode buildTree(String[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0].equals("null")) {
            return null;
        }
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();
            // 处理左子节点
            if (index < nodes.length && !nodes[index].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(current.left);
            }
            index++;
            //处理右子节点
            if (index < nodes.length && !nodes[index].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(current.right);
            }
            index++;
        }
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arrayP = br.readLine().trim();
        String arrayQ = br.readLine().trim();
        String[] strP = arrayP.split(",");
        String[] strQ = arrayQ.split(",");
        TreeNode rootP = buildTree(strP);
        TreeNode rootQ = buildTree(strQ);
        printTree(rootP);
        printTree(rootQ);
        System.out.println(new Solution().isSameTree(rootP, rootQ));
    }

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
