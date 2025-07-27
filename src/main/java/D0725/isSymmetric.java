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
class isSymmetric {

    public static void main(String[] args) {
        isSymmetric isSymmetric = new isSymmetric();
        boolean symmetric = isSymmetric.isSymmetric(
                TreeUtils.create(new int[]{1, 2, 3, 4, 2, 4, 3}, new int[]{3, 2, 4, 1, 4, 2, 3})
        );
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }
}