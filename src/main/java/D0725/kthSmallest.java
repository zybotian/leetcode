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
class kthSmallest {
    public static void main(String[] args) {
        TreeUtils.create(new int[]{}, new int[]{});
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = inorder(root);
        return result.get(k - 1);
    }

    private List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(inorder(root.left));
        }
        result.add(root.val);
        if (root.right != null) {
            result.addAll(inorder(root.right));
        }
        return result;
    }
}