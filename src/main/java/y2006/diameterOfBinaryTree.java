package y2006;

import common.TreeNode;

public class diameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        int rootDiameter = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
