package list;

import common.Node;

/**
 * @author tianbo
 * @date 2019-02-27
 */
public class NodeFlatten {

    static class Solution {
        public Node flatten(Node head) {
            Node cur = head;
            Node resultHead = null, resultCur = null;
            while (cur != null) {
                while (cur.next != null && cur.child == null) {
                    if (resultHead == null) {
                        resultHead = new Node(cur.val, null, null, null);
                        resultCur = resultHead;
                    } else {
                        Node tmp = new Node(cur.val, resultCur, null, null);
                        resultCur.next = tmp;
                        resultCur = tmp;
                    }
                    cur = cur.next;
                }

                Node node = new Node(cur.val, resultCur, null, null);
                if (resultCur != null) {
                    resultCur.next = node;
                    resultCur = node;
                } else {
                    resultHead = node;
                    resultCur = node;
                }

                // 递归处理孩子节点的链表
                if (cur.child != null) {
                    Node flattenHead = flatten(cur.child);
                    resultCur.next = flattenHead;
                    flattenHead.prev = resultCur;

                    while (resultCur != null && resultCur.next != null) {
                        resultCur = resultCur.next;
                    }
                }
                cur = cur.next;
//                while (cur != null) {
//                    Node tmp = new Node(cur.val, resultCur, null, null);
//                    resultCur.next = tmp;
//                    resultCur = tmp;
//                    cur = cur.next;
//                }
                // 递归处理后续部分的链表
                if (cur != null) {
                    Node flattenHead = flatten(cur);
                    resultCur.next = flattenHead;
                    flattenHead.prev = resultCur;
                }
            }

            return resultHead;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node node1 = getTestNode();
        display(solution.flatten(node1));

        Node node2 = getTestNode2();
        display(solution.flatten(node2));

    }

    private static Node getTestNode() {
        Node node1 = new Node(1, null, null, null);
        Node node2 = new Node(2, null, null, null);
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null, null, null);
        Node node7 = new Node(7, null, null, null);
        Node node8 = new Node(8, null, null, null);
        Node node9 = new Node(9, null, null, null);
        Node node10 = new Node(10, null, null, null);
        Node node11 = new Node(11, null, null, null);
        Node node12 = new Node(12, null, null, null);

        node1.next = node2;

        node2.next = node3;
        node2.prev = node1;

        node3.next = node4;
        node3.prev = node2;
        node3.child = node7;

        node4.next = node5;
        node4.prev = node3;

        node5.next = node6;
        node5.prev = node4;

        node6.prev = node5;

        node7.next = node8;

        node8.next = node9;
        node8.prev = node7;
        node8.child = node11;

        node9.next = node10;
        node9.prev = node8;

        node10.prev = node9;

        node11.next = node12;

        node12.prev = node11;
        return node1;
    }

    static void display(Node node) {
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
    }

    public static Node getTestNode2() {
        Node node3470 = new Node(3470, null, null, null);
        Node node121 = new Node(121, null, null, null);
        Node node4724 = new Node(4724, null, null, null);
        Node node4285 = new Node(4285, null, null, null);
        Node node917 = new Node(917, null, null, null);
        Node node721 = new Node(721, null, null, null);
        Node node1753 = new Node(1753, null, null, null);

        node3470.next = node121;
        node121.next = node4724;
        node4724.next = node4285;
        node917.next = node721;
        node121.child = node917;
        node4724.child = node1753;

        return node3470;
    }
}
