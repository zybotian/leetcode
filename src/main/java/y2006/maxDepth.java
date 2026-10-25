package y2006;

import common.TreeNode;
import util.TreeUtils;

public class maxDepth {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        maxDepth maxDepth = new maxDepth();
        System.out.println(maxDepth.maxDepth(treeNode));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
