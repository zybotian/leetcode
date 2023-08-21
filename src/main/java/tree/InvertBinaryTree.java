package tree;

import common.TreeNode;
import util.TreeUtils;

/**
 * @author tianbo
 * @date 2019-06-06
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;
        TreeUtils.visitInOrder(node4);

        TreeNode treeNode = invertTree(node4);
        TreeUtils.visitInOrder(treeNode);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 左子树翻转
        TreeNode left = invertTree(root.left);
        // 右子树翻转
        TreeNode right = invertTree(root.right);
        // 交换左右子树
        root.right = left;
        root.left = right;
        return root;
    }
}
