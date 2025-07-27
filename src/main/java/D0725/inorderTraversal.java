package D0725;

import common.TreeNode;
import util.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class inorderTraversal {

    public static void main(String[] args) {
        inorderTraversal inorderTraversal = new inorderTraversal();
        List<Integer> integers = inorderTraversal.inorderTraversal(TreeUtils.create(new int[]{1, 2, 3}, new int[]{1, 3, 2}));
        System.out.println(integers);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        if (root.left != null) {
            List<Integer> integers = inorderTraversal(root.left);
            result.addAll(integers);
        }

        result.add(root.val);

        if (root.right != null) {
            List<Integer> integers = inorderTraversal(root.right);
            result.addAll(integers);
        }
        return result;

    }
}