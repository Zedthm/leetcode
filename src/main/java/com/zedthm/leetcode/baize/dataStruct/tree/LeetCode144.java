package com.zedthm.leetcode.baize.dataStruct.tree;

import com.zedthm.leetcode.baize.dataStruct.linkList.LeetCode206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/4/3 10:12
 * @description:
 */
public class LeetCode144 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode (int val){
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
        Integer[] values = new Integer[arrStr.length];
        for (int i = 0; i < values.length; i++) {
            String num = arrStr[i].trim();
            if ("null".equals(num)) {
                values[i] = null;
            }
            else{
                values[i] = Integer.parseInt(num);
            }
        }
        TreeNode root = buildTree(values);
        List<Integer> result = preTravel (root);
        System.out.println(result.toString().replace(" ",""));
    }

    private static List<Integer> preTravel(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        treePreTravel(root, result);
        return result;
    }

    private static void treePreTravel(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        treePreTravel(node.left, result);
        treePreTravel(node.right, result);
    }

    private static TreeNode buildTree(Integer[] values) {
        if(values == null || values.length == 0|| values[0] ==null){
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode current = queue.poll();

            // 处理左子节点
            if (index < values.length && values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.offer(current.left);
            }
            index ++;

            //处理右子节点
            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.offer(current.right);
            }
            index ++;
        }
        return root;
    }

}
