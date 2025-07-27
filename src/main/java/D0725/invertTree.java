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
class invertTree {

    public static void main(String[] args) {
        invertTree invertTree = new invertTree();
        TreeNode treeNode = TreeUtils.create(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        TreeUtils.visitPreOrder(invertTree.invertTree(treeNode));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode invertLeft = invertTree(root.right);
        TreeNode invertRight = invertTree(root.left);
        root.right = invertLeft;
        root.left = invertRight;
        return root;
    }
}