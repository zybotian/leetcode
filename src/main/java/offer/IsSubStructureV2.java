package offer;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubStructureV2 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        if (A.val == B.val) {
            return isContains(A, B);
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
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
