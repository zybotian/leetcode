package y2006;

import common.TreeNode;

public class isSymmetric {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }
}
