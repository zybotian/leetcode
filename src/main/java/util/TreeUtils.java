package util;

import common.TreeNode;
import offer.BinTreeReCreate;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class TreeUtils {

    public static TreeNode create(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        return BinTreeReCreate.recreate(pre, in);
    }

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

    public static void visitPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        if (root.left != null) {
            visitPreOrder(root.left);
        }
        if (root.right != null) {
            visitPreOrder(root.right);
        }
    }
}
