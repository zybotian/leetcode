package tree;

import common.TreeNode;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-06-10
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;
        BinaryTreeRightSideView test = new BinaryTreeRightSideView();
        System.out.println(test.rightSideView(node1));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top == null) {
                list.add(null);
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            } else {
                list.add(top.val);
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null && i > 0 && list.get(i - 1) != null) {
                result.add(list.get(i - 1));
            }
        }
        return result;
    }
}
