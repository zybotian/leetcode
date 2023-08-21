package tree;

import common.TreeNode;
import util.TreeUtils;

/**
 * @author tianbo
 * @date 2019-03-05
 */
public class InsertIntoBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(30);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        Solution solution = new Solution();
        TreeUtils.visitInOrder(solution.insertIntoBST(node1, 25));
    }

    // 100%
    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }

            return root;
        }
    }
}
