package com.dataStructure.leetcode.二叉树;

/**
 * 只需将遍历到的每个节点的左右节点进行交换就可了，无需进行递归实现
 * 遍历就行
 */

public class _226_翻转二叉树 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return root;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null)
                invertTree(root.left);
            if (root.right != null)
                invertTree(root.right);
            return root;
        }
    }
}


 //Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

