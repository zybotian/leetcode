package tree;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class NaryTreeLevelOrder {
    public static void main(String[] args) {
        NaryTreeLevelOrder test = new NaryTreeLevelOrder();
        Solution solution = test.new Solution();

        Node node1 = test.new Node();
        Node node3 = test.new Node();
        Node node2 = test.new Node();
        Node node4 = test.new Node();
        Node node5 = test.new Node();
        Node node6 = test.new Node();

        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node6.val = 6;

        List<Node> childrens = new ArrayList<>();
        childrens.add(node3);
        childrens.add(node2);
        childrens.add(node4);

        List<Node> childrens2 = new ArrayList<>();
        childrens2.add(node5);
        childrens2.add(node6);

        node1.children = childrens;

        node3.children = childrens2;

        System.out.println(solution.levelOrder(node1));
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 击败89.85%, 和solution1相比, 不再使用null来标记一行的结束
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return new LinkedList<>();
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            List<List<Integer>> result = new LinkedList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new LinkedList<>();
                while (size != 0) {
                    Node top = queue.poll();
                    list.add(top.val);
                    if (top.children != null) {
                        for (Node node : top.children) {
                            queue.add(node);
                        }
                    }
                    size--;
                }
                result.add(list);
            }
            return result;
        }
    }

    // 击败32.45%
    class Solution1 {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return new LinkedList<>();
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            List<Integer> tmpResults = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node front = queue.remove();
                if (front != null) {
                    tmpResults.add(front.val);
                    if (front.children != null) {
                        for (Node node : front.children) {
                            queue.add(node);
                        }
                    }
                } else {
                    // 遇到null, 说明是一层的结束,如果队列变成空了,说明是整个树的遍历结束
                    tmpResults.add(null);
                    if (queue.isEmpty()) {
                        break;
                    }
                    queue.add(null);
                }
            }

            // 使用linkedList, 插入元素效率比ArrayList高
            List<List<Integer>> result = new LinkedList<>();
            List<Integer> tmpResult = new LinkedList<>();
            Iterator<Integer> iterator = tmpResults.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next != null) {
                    tmpResult.add(next);
                } else {
                    result.add(tmpResult);
                    tmpResult = new LinkedList<>();
                }
            }
            return result;
        }
    }
}
