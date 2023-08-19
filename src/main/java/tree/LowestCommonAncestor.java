package tree;

import common.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        if (p == q) {
            return p;
        }
        TreeNode treeNode1 = lowestCommonAncestor(root.left, p, q);
        TreeNode treeNode2 = lowestCommonAncestor(root.right, p, q);
        if (treeNode1 != null && treeNode2 != null) {
            return root;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return null;
        }
        return treeNode1 != null ? treeNode1 : treeNode2;
    }
}
