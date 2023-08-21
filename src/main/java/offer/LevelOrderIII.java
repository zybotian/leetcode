package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderIII {



    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> deque = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                if (reverse) {
                    deque.addFirst(treeNode.val);
                } else {
                    deque.addLast(treeNode.val);
                }

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(deque);
            reverse = !reverse;
        }

        return result;
    }
}
