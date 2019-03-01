package tree;

import common.TreeNode;

/**
 * @author tianbo
 * @date 2019-03-01
 */
public class CountNodes {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Solution solution = new Solution();
        System.out.println(solution.countNodes(node1));
    }

    static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            TreeNode left = root, right = root;
            int height = 0;
            while (right != null) {
                height++;
                left = left.left;
                right = right.right;
            }
            if (left == null) {
                // 说明是完全二叉树
                return (1 << height) - 1;
            }
            // 不是完全二叉树, 左边子树的节点数加上右边子树的节点数, 加上根节点
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
