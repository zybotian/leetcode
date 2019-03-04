package tree;

import common.TreeNode;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class LeafSimilar {
    public static void main(String[] args) {
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

        TreeNode node15 = new TreeNode(5);
        TreeNode node13 = new TreeNode(3);
        TreeNode node16 = new TreeNode(6);
        TreeNode node12 = new TreeNode(2);
        TreeNode node14 = new TreeNode(4);
        TreeNode node17 = new TreeNode(7);
        node15.left = node13;
        node15.right = node16;
        node13.left = node12;
        node13.right = node14;
        node16.left = node17;

        TreeNode node80 = new TreeNode(80);
        TreeNode node90 = new TreeNode(90);
        TreeNode node100 = new TreeNode(100);
        TreeNode node95 = new TreeNode(95);
        TreeNode node24 = new TreeNode(4);
        TreeNode node30 = new TreeNode(30);
        TreeNode node22 = new TreeNode(2);
        TreeNode node27 = new TreeNode(7);

        node80.left = node90;
        node80.right = node100;
        node90.left = node95;
        node90.right = node24;
        node100.left = node30;
        node95.left = node22;
        node30.right = node27;

        Solution solution = new Solution();
        System.out.println(solution.leafSimilar(node5, node5));
        System.out.println(solution.leafSimilar(node5, node15));
        System.out.println(solution.leafSimilar(node5, node80));

        System.out.println(solution.leafSimilar(node5, node3));
    }

    // 击败98.94%, 最简洁的代码
    static class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leafNodes1 = new ArrayList();
            List<Integer> leafNodes2 = new ArrayList();
            visitNodes(root1, leafNodes1);
            visitNodes(root2, leafNodes2);
            return leafNodes1.equals(leafNodes2);
        }

        public void visitNodes(TreeNode node, List<Integer> leafValues) {
            if (node != null) {
                if (node.left == null && node.right == null) {
                    leafValues.add(node.val);
                }
                visitNodes(node.left, leafValues);
                visitNodes(node.right, leafValues);
            }
        }
    }

    // 击败98.94%
    static class Solution1 {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            return sameList(getLeafNodes(root1), getLeafNodes(root2));
        }

        // 使用中序遍历, 得到所有的叶子节点
        private List<Integer> getLeafNodes(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            // 结果, 使用arrayList
            List<Integer> result = new ArrayList<>();

            // linked list作为栈使用
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;

            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }

                if (!stack.isEmpty()) {
                    p = stack.pop();
                    if (p != null && p.left == null && p.right == null) {
                        result.add(p.val);
                    }
                    p = p.right;
                }
            }
            return result;
        }

        // ArrayList自带的equals方法也可以, 但是实现上是通过迭代器来遍历的, 对于数组来说,下标遍历效率更高
        private boolean sameList(List<Integer> leafNodes1, List<Integer> leafNodes2) {
            if (leafNodes1.size() != leafNodes2.size()) {
                return false;
            }

            int size = leafNodes1.size();

            // array list, 否则效率太低
            for (int i = 0; i < size; i++) {
                if (leafNodes1.get(i).intValue() != leafNodes2.get(i)) {
                    return false;
                }
            }

            return true;
        }
    }
}
