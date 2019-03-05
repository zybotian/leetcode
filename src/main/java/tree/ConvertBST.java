package tree;

import common.TreeNode;

import util.TreeDisplay;

/**
 * @author tianbo
 * @date 2019-03-05
 */
public class ConvertBST {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node13 = new TreeNode(13);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node24 = new TreeNode(24);
        TreeNode node6 = new TreeNode(6);
        TreeNode node32 = new TreeNode(32);
        node5.left = node2;
        node5.right = node13;
        node2.left = node1;
        node2.right = node4;
        node13.left = node8;
        node13.right = node24;
        node8.left = node6;
        node24.right = node32;

        Solution solution = new Solution();
        TreeDisplay.visitInOrder(node5);
        System.out.println("_________________________");

        TreeDisplay.visitInOrder(solution.convertBST(node5));
    }

    // 击败100%
    static class Solution {
        private int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root != null) {
                convertBST(root.right);
                sum += root.val;
                root.val = sum;
                convertBST(root.left);
            }
            return root;
        }
    }

    // 击败92.58%
    static class Solution1 {
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            // 只有根节点
            if (root.left == null && root.right == null) {
                return root;
            }

            // 有右子树
            if (root.right != null) {
                // 先将右子树转成正确的树
                TreeNode treeNode = convertBST(root.right);
                // 找到右边子树的最左叶子节点,它的值是整个右边子树的和
                TreeNode p = treeNode;
                while (p != null && p.left != null) {
                    p = p.left;
                }
                // 根节点的值加上右子树的和,是新的根节点的值
                root.val += p.val;
            }

            // 有左子树
            if (root.left != null) {
                // 将左子树转成正确的树
                TreeNode treeNode = convertBST(root.left);
                // 遍历左子树, 将每隔节点的值加上根节点的值
                visitAndIncrease(treeNode, root.val);
            }
            return root;
        }

        private void visitAndIncrease(TreeNode root, int val) {
            if (root != null) {
                root.val += val;
                visitAndIncrease(root.left, val);
                visitAndIncrease(root.right, val);
            }
        }
    }
}
