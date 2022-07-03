package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthLargestV2 {

    public int kthLargest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }
        List<Integer> inorderList = getInorderList(root, k);
        return inorderList.get(k - 1);
    }

    private List<Integer> getInorderList(TreeNode root, int k) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        List<Integer> rightInorderList = getInorderList(root.right, k);
        if (rightInorderList != null && rightInorderList.size() > 0) {
            result.addAll(rightInorderList);
        }

        if (result.size() >= k) {
            return result;
        }

        result.add(root.val);

        if (result.size() >= k) {
            return result;
        }

        List<Integer> leftInorderList = getInorderList(root.left, k);
        if (leftInorderList != null && leftInorderList.size() > 0) {
            result.addAll(leftInorderList);
        }

        return result;
    }
}
