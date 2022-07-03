package offer;

import common.TreeNode;

public class KthLargestV3 {

    private int cnt;
    private int result;

    public int kthLargest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }
        cnt = k;
        reverseInorder(root);
        return result;
    }

    private void reverseInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        reverseInorder(root.right);

        if (cnt == 0) {
            return;
        }
        if (--cnt == 0) {
            result = root.val;
            return;
        }
        reverseInorder(root.left);
    }
}
