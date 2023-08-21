package tree;

import common.TreeNode;
import util.TreeUtils;

import java.util.LinkedList;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class IncreasingBST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node7;
        TreeUtils.display(solution.increasingBST(node5));
    }

    // 100%, 遍历时直接修改指针, 只需要一次遍历, 效率进一步提高
    static class Solution {

        TreeNode previous;

        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummy = new TreeNode(0);
            previous = dummy;
            inorder(root);
            return dummy.right;
        }

        private void inorder(TreeNode node) {
            if (node == null) {
                return;
            }

            inorder(node.left);
            node.left = null;
            previous.left = null;
            previous.right = node;
            previous = node;
            inorder(node.right);
        }
    }


    // 递归遍历二叉树改成非递归遍历, 性能提升明显, 72.42%, 需要遍历两次
    static class Solution2 {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            // 将linkedList当做队列使用
            LinkedList<TreeNode> treeNodeQueue = visitInOrder(root);
            TreeNode result = treeNodeQueue.getFirst();

            while (!treeNodeQueue.isEmpty()) {
                TreeNode first = treeNodeQueue.removeFirst();
                first.left = null;
                first.right = null;
                if (!treeNodeQueue.isEmpty()) {
                    TreeNode currentFirst = treeNodeQueue.getFirst();
                    first.right = currentFirst;
                }
            }

            return result;
        }

        // 注意这里返回Linked list, 不是list接口类
        private LinkedList<TreeNode> visitInOrder(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }

            LinkedList<TreeNode> result = new LinkedList<>();

            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;

            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }

                if (!stack.isEmpty()) {
                    p = stack.pop();
                    result.add(p);
                    p = p.right;
                }
            }

            return result;
        }
    }

    // 48.35%
    static class Solution1 {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            // 将linkedList当做队列使用
            LinkedList<TreeNode> treeNodeQueue = visitInOrder(root);
            TreeNode result = treeNodeQueue.getFirst();

            while (!treeNodeQueue.isEmpty()) {
                TreeNode first = treeNodeQueue.removeFirst();
                first.left = null;
                first.right = null;
                if (!treeNodeQueue.isEmpty()) {
                    TreeNode currentFirst = treeNodeQueue.getFirst();
                    first.right = currentFirst;
                }
            }

            return result;
        }

        // 注意这里返回Linked list, 不是list接口类
        private LinkedList<TreeNode> visitInOrder(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }

            LinkedList<TreeNode> result = new LinkedList<>();

            if (root.left != null) {
                result.addAll(visitInOrder(root.left));
            }

            result.add(root);
            if (root.right != null) {
                result.addAll(visitInOrder(root.right));
            }

            return result;
        }
    }
}
