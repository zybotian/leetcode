package y2006;

import common.TreeNode;
import util.TreeUtils;

public class invertTree {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create(new int[]{4, 2, 1, 3, 7, 6, 9}, new int[]{1, 2, 3, 4, 6, 7, 9});

        invertTree invertTree = new invertTree();
        invertTree.invertTree(treeNode);
        TreeUtils.visitPreOrder(treeNode);
        System.out.println("---");
        TreeUtils.visitInOrder(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftResult = invertTree(root.left);
        TreeNode rightResult = invertTree(root.right);
        root.left = rightResult;
        root.right = leftResult;
        return root;
    }
}
