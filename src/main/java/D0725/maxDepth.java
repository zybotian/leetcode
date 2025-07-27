package D0725;

import common.TreeNode;
import util.TreeUtils;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class maxDepth {
    public static void main(String[] args) {
        maxDepth maxDepth = new maxDepth();
        int i = maxDepth.maxDepth(TreeUtils.create(new int[]{1, 2, 3}, new int[]{1, 3, 2}));
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}