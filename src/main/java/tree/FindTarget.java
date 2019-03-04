package tree;

import common.TreeNode;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class FindTarget {
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
        Solution solution = new Solution();
        System.out.println(solution.findTarget(node5, 9));
        System.out.println(solution.findTarget(node5, 28));
    }

    // 84.28%, 将递归遍历改成非递归遍历,并且使用linkedlist作为stack来使用
    static class Solution {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> nodeValues = visitInOrder(root);
            int[] integers = new int[nodeValues.size()];
            int index = 0;
            // 遍历linked list, for each方式底层依然会被优化成iterator的方式进行迭代
            Iterator<Integer> iterator = nodeValues.iterator();
            while (iterator.hasNext()) {
                integers[index++] = iterator.next();
            }
            // 使用基本类型进行二分查找, 若使用对象类型,比较时需要调用compareTo方法,闲人效率比直接数字比较低
            for (int i = 0; i < integers.length; i++) {
                if (Arrays.binarySearch(integers, i + 1, integers.length, k - integers[i]) >= 0) {
                    return true;
                }
            }
            return false;
        }

        private List<Integer> visitInOrder(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }

            List<Integer> result = new LinkedList<>();

            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                if (!stack.isEmpty()) {
                    p = stack.element();
                    result.add(p.val);
                    stack.pop();
                    p = p.right;
                }
            }
            return result;
        }
    }

    // 55.26%
    static class Solution3 {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> nodeValues = visitInOrder(root);
            int[] integers = new int[nodeValues.size()];
            int index = 0;
            // 遍历linked list, for each方式底层依然会被优化成iterator的方式进行迭代
            Iterator<Integer> iterator = nodeValues.iterator();
            while (iterator.hasNext()) {
                integers[index++] = iterator.next();
            }
            // 使用基本类型进行二分查找, 若使用对象类型,比较时需要调用compareTo方法,闲人效率比直接数字比较低
            for (int i = 0; i < integers.length; i++) {
                if (Arrays.binarySearch(integers, i + 1, integers.length, k - integers[i]) >= 0) {
                    return true;
                }
            }
            return false;
        }

        private List<Integer> visitInOrder(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            List<Integer> tmp = new LinkedList<>();
            if (root.left != null) {
                tmp.addAll(visitInOrder(root.left));
            }
            tmp.add(root.val);
            if (root.right != null) {
                tmp.addAll(visitInOrder(root.right));
            }
            return tmp;
        }
    }

    // 55.26%
    static class Solution2 {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> nodeValues = visitInOrder(root);
            Integer[] integers = nodeValues.toArray(new Integer[0]);
            for (int i = 0; i < integers.length; i++) {
                if (Arrays.binarySearch(integers, i + 1, integers.length, k - integers[i]) >= 0) {
                    return true;
                }
            }
            return false;
        }

        private List<Integer> visitInOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> tmp = new ArrayList<>();
            if (root.left != null) {
                tmp.addAll(visitInOrder(root.left));
            }
            tmp.add(root.val);
            if (root.right != null) {
                tmp.addAll(visitInOrder(root.right));
            }
            return tmp;
        }
    }

    // 21.8%, 效率低下
    static class Solution1 {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> nodeValues = visitInOrder(root);
            Map<Integer, Integer> valueMap = new HashMap<>();
            for (Integer val : nodeValues) {
                if (valueMap.containsKey(val)) {
                    valueMap.put(val, valueMap.get(val) + 1);
                } else {
                    valueMap.put(val, 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : valueMap.entrySet()) {
                int diff = k - entry.getKey();
                if (valueMap.containsKey(diff)) {
                    if (diff == entry.getKey() && entry.getValue() >= 2) {
                        return true;
                    }
                    if (diff != entry.getKey()) {
                        return true;
                    }
                }
            }
            return false;
        }

        private List<Integer> visitInOrder(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            List<Integer> tmp = new LinkedList<>();
            if (root.left != null) {
                tmp.addAll(visitInOrder(root.left));
            }
            tmp.add(root.val);
            if (root.right != null) {
                tmp.addAll(visitInOrder(root.right));
            }
            return tmp;
        }
    }
}
