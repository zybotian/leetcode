package tree;

import common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class IsCousins {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node4.left = node6;
        node5.right = node7;
        System.out.println(solution.isCousins(node1, 4, 5));
        System.out.println(solution.isCousins(node1, 6, 7));
        System.out.println(solution.isCousins(node1, 2, 3));
        System.out.println(solution.isCousins(node1, 2, 5));
        System.out.println(solution.isCousins(node1, 3, 4));
        System.out.println(solution.isCousins(node1, 2, 2));
        System.out.println(solution.isCousins(node1, 2, 6));
        System.out.println(solution.isCousins(node1, 3, 7));
    }

    // 击败96.95, 二叉树的层次遍历
    static class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) {
                return false;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            Map<Integer, Integer> nodeParentMap = new HashMap<>();

            while (!queue.isEmpty()) {
                nodeParentMap.clear();
                int size = queue.size();
                while (size != 0) {
                    TreeNode top = queue.poll();
                    if (top.left != null) {
                        queue.add(top.left);
                        nodeParentMap.put(top.left.val, top.val);
                    }
                    if (top.right != null) {
                        queue.add(top.right);
                        nodeParentMap.put(top.right.val, top.val);
                    }
                    size--;
                }

                if (x != y && nodeParentMap.containsKey(x) && nodeParentMap.containsKey(y) && nodeParentMap.get(x)
                        .intValue() != nodeParentMap.get(y).intValue()) {
                    return true;
                }
            }

            return false;
        }
    }
}
