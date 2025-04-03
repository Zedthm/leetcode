package com.zedthm.leetcode.baize.dataStruct.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/3 10:40
 * @description:
 */
public class LeetCode94 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] arrStr = line.split(",");
        Integer[] arr = new Integer[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            if ("null".equals(arrStr[i])) {
                arr[i] = null;
            } else {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
        }
        TreeNode root = buildTree(arr);
        List<Integer> result = inorderTravel(root);
        System.out.println(result.toString().replace(" ", ""));
    }

    private static List<Integer> inorderTravel(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        treeInorderTravel(root,result);
        return result;
    }

    private static void treeInorderTravel(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        treeInorderTravel(node.left, result);
        result.add(node.val);
        treeInorderTravel(node.right, result);
    }

    private static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index  = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode node = queue.poll();
            if (index < values.length && values[index] != null) {
                node.left = new TreeNode(values[index]);
                queue.offer(node.left);
            }
            index ++;

            if (index < values.length && values[index] != null) {
                node.right = new TreeNode(values[index]);
                queue.offer(node.right);
            }
            index ++;
        }
        return root;
    }
}
