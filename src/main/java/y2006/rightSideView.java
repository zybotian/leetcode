package y2006;

import common.TreeNode;
import util.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class rightSideView {

    public static void main(String[] args) {
        rightSideView rightSideView = new rightSideView();
        TreeNode treeNode = TreeUtils.create(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        List<Integer> integers = rightSideView.rightSideView(treeNode);
        System.out.println(integers);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
