package tree;

import common.TreeNode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int rootPathDiameter = rootPath(root);
        return Math.max(Math.max(leftDiameter, rightDiameter), rootPathDiameter);
    }

    private int rootPath(TreeNode root) {
        return maxDepth(root.left) + maxDepth(root.right) - 1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
