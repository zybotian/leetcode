package offer;

import common.TreeNode;
import util.TreeUtils;

import java.util.*;

public class TreeCodec {

    public static void main(String[] args) {
        TreeCodec treeCodec = new TreeCodec();
        TreeNode treeNode = TreeUtils.create(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5});
        String serialize = treeCodec.serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = treeCodec.deserialize(serialize);
        TreeUtils.visitPreOrder(deserialize);
        System.out.println();
        TreeUtils.visitInOrder(deserialize);
        System.out.println();

        TreeNode treeNode2 = TreeUtils.create(new int[]{1}, new int[]{1});
        String serialize2 = treeCodec.serialize(treeNode2);
        System.out.println(serialize2);
        TreeNode deserialize2 = treeCodec.deserialize(serialize2);
        TreeUtils.visitPreOrder(deserialize2);
        System.out.println();
        TreeUtils.visitInOrder(deserialize2);
    }


    public String serialize(TreeNode root) {
        if (root == null) {
            return "NULL";
        }

        return new StringBuilder()
                .append(root.val)
                .append(",")
                .append(serialize(root.left))
                .append(",")
                .append(serialize(root.right))
                .toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            queue.add(nodes[i]);
        }
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        String node = queue.poll();
        if ("NULL".equals(node)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
