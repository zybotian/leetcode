package offer;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        if (isContains(A, B)) {
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSubStructureV2(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (isContains(treeNode, B)) {
                return true;
            }
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return false;
    }

    private boolean isContains(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        return root1.val == root2.val && isContains(root1.left, root2.left) && isContains(root1.right, root2.right);
    }
}
