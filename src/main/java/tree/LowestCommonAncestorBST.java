package tree;

import common.TreeNode;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-03-05
 */
public class LowestCommonAncestorBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        Solution solution = new Solution();
        // 0,3: 2
        System.out.println(solution.lowestCommonAncestor(node1, node4, node8));
        // 5,7: 6
        System.out.println(solution.lowestCommonAncestor(node1, node6, node9));
        // 4,9: 6
        System.out.println(solution.lowestCommonAncestor(node1, node5, node7));
        // 0,2: 2
        System.out.println(solution.lowestCommonAncestor(node1, node4, node2));
        // 6,3: 6
        System.out.println(solution.lowestCommonAncestor(node1, node1, node8));
        // 5,2: 2
        System.out.println(solution.lowestCommonAncestor(node1, node2, node9));

    }

    // 击败100%
    static class Solution {
        /**
         * 1.其中一个是根节点时,返回根节点
         * 2.一个在左子树,一个在右子树时,返回根节点
         * 3.都在左子树, 查找范围缩小,新的root=root.left
         * 4.都在右子树, 查找范围缩小,新的root=root.right
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // p是根节点
            if (p.val == root.val && q.val != root.val) {
                return root;
            }

            // q是根节点
            if (q.val == root.val && p.val != root.val) {
                return root;
            }

            // 一个在左子树,一个在右子树, 则LCA是root
            if ((p.val < root.val && q.val > root.val) || (q.val < root.val && p.val > root.val)) {
                return root;
            }

            // 都在左子树
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }

            // 都在右子树
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    // 击败12.42%, 效率太低了
    static class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // q是p的孩子,返回p
            if (p.left == q || p.right == q) {
                return p;
            }

            // p是q的孩子,返回q
            if (q.left == p || q.right == p) {
                return q;
            }

            Map<TreeNode, TreeNode> nodeParentsMap = new HashMap<>();
            visitPreOrder(root, nodeParentsMap);

            LinkedList<TreeNode> pParentsStack = new LinkedList<>();
            pParentsStack.push(p);

            LinkedList<TreeNode> qParentsStack = new LinkedList<>();
            qParentsStack.push(q);

            TreeNode cur = p;
            while (cur != root) {
                TreeNode parents = nodeParentsMap.get(cur);
                pParentsStack.push(parents);
                cur = parents;
            }
            if (pParentsStack.isEmpty()) {
                pParentsStack.push(root);
            }

            cur = q;
            while (cur != root) {
                TreeNode parents = nodeParentsMap.get(cur);
                qParentsStack.push(parents);
                cur = parents;
            }
            if (qParentsStack.isEmpty()) {
                qParentsStack.push(root);
            }

            TreeNode result = null;
            while (!pParentsStack.isEmpty() && !qParentsStack.isEmpty()) {
                TreeNode pParents = pParentsStack.pop();
                TreeNode qParents = qParentsStack.pop();
                if (pParents != qParents) {
                    break;
                }
                result = pParents;
            }

            return result;
        }

        private void visitPreOrder(TreeNode root, Map<TreeNode, TreeNode> nodeParentsMap) {
            if (root != null) {
                if (root.left != null) {
                    nodeParentsMap.put(root.left, root);
                    visitPreOrder(root.left, nodeParentsMap);
                }
                if (root.right != null) {
                    nodeParentsMap.put(root.right, root);
                    visitPreOrder(root.right, nodeParentsMap);
                }
            }
        }
    }
}
