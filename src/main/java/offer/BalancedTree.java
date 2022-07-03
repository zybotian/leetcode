package offer;

import common.TreeNode;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        // 平衡二叉树定义：是一棵空树或左右子树的高度差绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
        if (root == null) {
            return true;
        }

        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
