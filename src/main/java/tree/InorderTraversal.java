package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        List<Integer> left = inorderTraversal(root.left);
        if (left != null && !left.isEmpty()) {
            result.addAll(left);
        }
        result.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        if (right != null && !right.isEmpty()) {
            result.addAll(right);
        }

        return result;
    }
}
