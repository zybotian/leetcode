package y2006;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class kthSmallest {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> inOrder = inorderTraversal(root);
        return inOrder.get(k - 1);
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}
