package offer;

import common.TreeNode;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        return root.left.val == root.right.val && isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val
                && isSymmetric(root1.left, root2.right)
                && isSymmetric(root1.right, root2.left)
                ;
    }
}
