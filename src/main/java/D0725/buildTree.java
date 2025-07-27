package D0725;

import common.TreeNode;
import util.TreeUtils;

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
class buildTree {

    public static void main(String[] args) {
        buildTree buildTree = new buildTree();
        TreeNode treeNode = buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeUtils.visitPreOrder(treeNode);
        TreeUtils.visitInOrder(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndexInOrder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                rootIndexInOrder = i;
                break;
            }
        }
        int leftChildNum = rootIndexInOrder - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftChildNum, inorder, inStart, inStart + leftChildNum - 1);
        root.right = buildTree(preorder, preStart + leftChildNum + 1, preEnd, inorder, rootIndexInOrder + 1, inEnd);
        return root;
    }

}