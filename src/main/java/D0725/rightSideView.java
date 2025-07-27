package D0725;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levelOrder = levelOrder(root);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < levelOrder.size(); i++) {
            List<Integer> integers = levelOrder.get(i);
            result.add(integers.get(integers.size() - 1));
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currentRes = new ArrayList<>();
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode pop = queue.poll();
                currentRes.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            result.add(currentRes);
        }

        return result;
    }
}