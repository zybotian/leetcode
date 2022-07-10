package tree;

import common.TreeNode;

import util.TreeUtils;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class TrimBST {
    // 击败100%
    static class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) {
                return root;
            }
            if (root.val > R) {
                return trimBST(root.left, L, R);
            }
            if (root.val < L) {
                return trimBST(root.right, L, R);
            }

            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeUtils.visitInOrder(solution.trimBST(createTree(), 1, 10));
        System.out.println();

        TreeUtils.visitInOrder(solution.trimBST(createTree(), 1, 7));
        System.out.println();

        TreeUtils.visitInOrder(solution.trimBST(createTree(), 1, 6));
        System.out.println();

        TreeUtils.visitInOrder(solution.trimBST(createTree(), 1, 5));
        System.out.println();

        TreeUtils.visitInOrder(solution.trimBST(createTree(), 4, 7));
        System.out.println();

    }

    private static TreeNode createTree() {
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
        return node5;
    }
}
