package tree;

import common.TreeNode;

public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int leftSum = pathSum(root.left, targetSum);
        int rightSum = pathSum(root.right, targetSum);
        int rootSum = rootPathSum(root, targetSum);
        return leftSum + rightSum + rootSum;
    }

    private int rootPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == targetSum) {
            count = 1;
        }
        count += rootPathSum(root.left, targetSum - root.val);
        count += rootPathSum(root.right, targetSum - root.val);
        return count;
    }
}
