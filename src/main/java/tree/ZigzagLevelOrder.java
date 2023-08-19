package tree;

import common.TreeNode;
import util.TreeUtils;

import java.util.*;

public class ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        System.out.println(zigzagLevelOrder.zigzagLevelOrder(treeNode));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();
        boolean order = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (order) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            order = !order;
            result.add(list);
        }

        return result;
    }
}
