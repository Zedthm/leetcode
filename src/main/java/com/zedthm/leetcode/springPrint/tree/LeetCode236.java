package com.zedthm.leetcode.springPrint.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/31 15:36
 * @description:
 */
public class LeetCode236 {
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
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();
            if (index < nodes.length && !nodes[index].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(current.left);
            }
            index++;
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
        String line = br.readLine().trim();
        String[] str = line.split(",");
        TreeNode root = buildTree(str);
        int p = Integer.parseInt(br.readLine().trim());
        int q = Integer.parseInt(br.readLine().trim());
        TreeNode result = new Solution().lowestCommonAncestor(root, new TreeNode(p), new TreeNode(q));
        System.out.println(result.val);
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            }

            if (left != null) {
                return left;
            }
            if (right != null) {
                 return right;
            }
             return null;
        }
    }
}
