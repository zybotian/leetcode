package util;

import common.TreeNode;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class TreeDisplay {
    public static void display(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            System.out.print(p.val + "\t");
            p = p.right;
        }
        System.out.println();
    }

    public static void visitInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            visitInOrder(root.left);
        }
        System.out.print(root.val + "\t");
        if (root.right != null) {
            visitInOrder(root.right);
        }
    }
}
