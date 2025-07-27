package D0725;

import common.TreeNode;

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
class pathSum {
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        // 递归处理左子树
        int sumLeft = pathSum(root.left, targetSum);
        // 递归处理右子树
        int sumRight = pathSum(root.right, targetSum);

        // 从当前节点出发，和为target的路径
        int sumRoot = countPathFromRoot(root, targetSum);
        return sumRoot + sumLeft + sumRight;
    }

    private int countPathFromRoot(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        long result = 0;
        if (root.val == targetSum) {
            result++;
        }
        result += countPathFromRoot(root.left, targetSum - root.val);
        result += countPathFromRoot(root.right, targetSum - root.val);
        return (int) result;
    }
}