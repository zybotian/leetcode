package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<Integer> path = new LinkedList<>();
        pathSum(root, target, path);

        return result;
    }

    private void pathSum(TreeNode root, int target, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }

        // 先遍历根节点
        path.add(root.val);
        target -= root.val;

        if (root.left == null && root.right == null) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
            }
        } else {
            // 再遍历左右子树
            pathSum(root.left, target, path);
            pathSum(root.right, target, path);
        }
        // 回溯
        path.removeLast();
    }
}
