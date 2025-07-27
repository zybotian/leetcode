package D0725;

import common.TreeNode;
import util.TreeUtils;

import java.util.ArrayList;
import java.util.List;

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
class isValidBST {

    public static void main(String[] args) {
        isValidBST isValidBST = new isValidBST();
        TreeNode treeNode = TreeUtils.create(new int[]{2, 2, 2}, new int[]{2, 2, 2});
        System.out.println(isValidBST.isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = inorder(root);
        if (inorderList != null && inorderList.size() > 0) {
            for (int i = 0, size = inorderList.size(); i < size - 1; i++) {
                if (inorderList.get(i) >= inorderList.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        List<Integer> left = inorder(root.left);
        result.addAll(left);

        result.add(root.val);

        List<Integer> right = inorder(root.right);
        result.addAll(right);
        return result;
    }


}