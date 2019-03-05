package tree;

import common.TreeNode;

/**
 * @author tianbo
 * @date 2019-03-05
 */
public class FindTilt {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(solution.findTilt(node1));
    }

    // 击败100%
    static class Solution {
        int tilt = 0;

        public int findTilt(TreeNode root) {
            sumTree(root);
            return tilt;
        }

        private int sumTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sumLeftSubtree = sumTree(root.left);
            int sumRightSubtree = sumTree(root.right);
            tilt += Math.abs(sumLeftSubtree - sumRightSubtree);
            return root.val + sumLeftSubtree + sumRightSubtree;
        }
    }
}
