package tree;

import common.TreeNode;
import util.TreeUtils;

public class MaxPathSum {

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        TreeNode root = TreeUtils.create(new int[]{-10, 9, 20, 15, 7}, new int[]{9, -10, 15, 20, 7});
        System.out.println(maxPathSum.maxPathSum(root));
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathOneSide(root);
        return max;
    }

    // 以root为根节点的左子树或右子树中的最大路径和
    private int maxPathOneSide(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 左子树的最大路径和
        int leftMax = maxPathOneSide(root.left);
        // 右子树的最大路径和
        int rightMax = maxPathOneSide(root.right);
        // 包含当前root节点的最大路径和
        int tmpResult = root.val + Math.max(0, leftMax) + Math.max(0, rightMax);
        // 更新全局的最大值
        max = Math.max(max, tmpResult);
        // 以root为根节点的左子树或右子树的最大路径和
        int result = root.val + Math.max(Math.max(0, leftMax), Math.max(0, rightMax));
        return result;
    }

}
