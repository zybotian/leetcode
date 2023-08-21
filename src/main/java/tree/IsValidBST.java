package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author tianbo
 * @date 2019-03-08
 */
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node10 = new TreeNode(1);
        TreeNode node30 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node18 = new TreeNode(6);
//        TreeNode node22 = new TreeNode(22);
//        TreeNode node32 = new TreeNode(32);

        root.left = node10;
        root.right = node30;
//        node30.left = node2;
//        node30.right = node18;
//        node30.left = node22;
//        node30.right = node32;

        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }

    // 击败40.24%
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null || (root != null && root.left == null && root.right == null)) {
                return true;
            }
            return visit(root);
        }

        private boolean visit(TreeNode root) {
            if (root == null) {
                return true;
            }

            long cur = Long.MIN_VALUE;
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                if (!stack.isEmpty()) {
                    p = stack.peek();
                    if (p.val <= cur) {
                        return false;
                    }
                    cur = p.val;
                    stack.pop();
                    p = p.right;
                }
            }
            return true;
        }
    }

    // 击败11.08%, 效率依然很低下
    static class Solution2 {
        public boolean isValidBST(TreeNode root) {
            if (root == null || (root != null && root.left == null && root.right == null)) {
                return true;
            }

            LinkedList<Integer> nodes = visit(root);
            Iterator<Integer> iterator = nodes.iterator();
            int pre = iterator.next();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next <= pre) {
                    return false;
                }
                pre = next;
            }
            return true;
        }

        private LinkedList<Integer> visit(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }

            LinkedList<Integer> result = new LinkedList<>();

            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                if (!stack.isEmpty()) {
                    p = stack.peek();
                    result.add(p.val);
                    stack.pop();
                    p = p.right;
                }
            }
            return result;
        }
    }

    // 击败6.99%, 效率太低
    static class Solution1 {
        public boolean isValidBST(TreeNode root) {
            if (root == null || (root != null && root.left == null && root.right == null)) {
                return true;
            }

            List<Integer> nodes = visit(root);
            int pre = nodes.get(0);
            for (int i = 1; i < nodes.size(); i++) {
                if (nodes.get(i).intValue() <= pre) {
                    return false;
                }
                pre = nodes.get(i);
            }
            return true;
        }

        private List<Integer> visit(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> result = new ArrayList<>();

            if (root.left != null) {
                result.addAll(visit(root.left));
            }
            result.add(root.val);
            if (root.right != null) {
                result.addAll(visit(root.right));
            }
            return result;
        }
    }
}
