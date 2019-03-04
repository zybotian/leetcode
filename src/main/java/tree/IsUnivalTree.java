package tree;

import common.TreeNode;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class IsUnivalTree {
    // 击败100%
    static class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left == null && root.right == null) {
                return true;
            }
            int val = root.val;
            if (root.left != null) {
                boolean matched = root.left.val == val && isUnivalTree(root.left);
                if (!matched) {
                    return false;
                }
            }

            if (root.right != null) {
                boolean matched = root.right.val == val && isUnivalTree(root.right);
                if (!matched) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node7;
        Solution solution = new Solution();
        System.out.println(solution.isUnivalTree(node5));

        node2.val = 1;
        node3.val = 1;
        node4.val = 1;
        node5.val = 1;
        node6.val = 1;
        System.out.println(solution.isUnivalTree(node5));

        node7.val = 1;
        System.out.println(solution.isUnivalTree(node5));
    }
}
