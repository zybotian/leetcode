package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianbo
 * @date 2019-08-23
 */
public class PathInBinaryTree {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> findPath(TreeNode root, int target) {
        findPath(root, target, new ArrayList<>());
        return res;
    }

    private static void findPath(TreeNode root, int target, List<Integer> tmp) {
        if (root == null) {
            return;
        }

        tmp.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            findPath(root.left, target, tmp);
            findPath(root.right, target, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node12 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        root.left = node5;
        root.right = node12;
        node5.left = node4;
        node5.right = node7;

        System.out.println(findPath(root, 22));
    }
}
