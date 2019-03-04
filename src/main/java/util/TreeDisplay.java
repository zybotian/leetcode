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
}
