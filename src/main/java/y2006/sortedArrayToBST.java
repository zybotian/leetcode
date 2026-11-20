package y2006;

import common.TreeNode;

public class sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        }
        int middle = (startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        TreeNode left = sortedArrayToBST(nums, startIndex, middle - 1);
        TreeNode right = sortedArrayToBST(nums, middle + 1, endIndex);
        root.left = left;
        root.right = right;
        return root;
    }

}
