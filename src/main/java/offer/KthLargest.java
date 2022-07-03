package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {

    public int kthLargest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }
        List<Integer> inorderList = getInorderList(root);
        return inorderList.get(inorderList.size() - k);
    }

    private List<Integer> getInorderList(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> leftInorderList = getInorderList(root.left);
        if (leftInorderList != null && leftInorderList.size() > 0) {
            result.addAll(leftInorderList);
        }
        result.add(root.val);
        List<Integer> rightInorderList = getInorderList(root.right);
        if (rightInorderList != null && rightInorderList.size() > 0) {
            result.addAll(rightInorderList);
        }

        return result;
    }
}
