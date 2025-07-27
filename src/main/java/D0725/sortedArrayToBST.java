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

class sortedArrayToBST {

    public static void main(String[] args) {
        sortedArrayToBST sortedArrayToBST = new sortedArrayToBST();
        TreeUtils.visitInOrder(sortedArrayToBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildSearchTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildSearchTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int middle = start + (end - start) / 2;
        TreeNode left = buildSearchTree(nums, start, middle - 1);
        TreeNode right = buildSearchTree(nums, middle + 1, end);

        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }
}