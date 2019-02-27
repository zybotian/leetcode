package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianbo
 * @date 2019-02-27
 */
public class CopyRandomList {

    static class Solution {
        public Node copyRandomList(Node head) {
            Node resultHead = null, resultCur = null;
            Node cur = head;
            Map<Node, Node> oldNewNodeMap = new HashMap<>();
            Map<Node, Node> newOldNodeMap = new HashMap<>();

            // 构造next链条,以及映射关系
            while (cur != null) {
                Node tmp = new Node(cur.val, null, null);
                if (resultHead == null) {
                    resultHead = tmp;
                    resultCur = tmp;
                } else {
                    resultCur.next = tmp;
                    resultCur = tmp;
                }
                newOldNodeMap.put(tmp, cur);
                oldNewNodeMap.put(cur, tmp);
                cur = cur.next;
            }
            // 构造随机指针
            resultCur = resultHead;
            while (resultCur != null) {
                // 找到当前node对应的原始node
                Node oldNode = newOldNodeMap.get(resultCur);
                // 找到原来node的random节点
                Node oldNodeRandom = oldNode.random;
                if (oldNodeRandom != null) {
                    // 找到原来node的random节点的对应的新node
                    Node newNode = oldNewNodeMap.get(oldNodeRandom);
                    resultCur.random = newNode;
                }
                // 继续下一个节点
                resultCur = resultCur.next;
            }
            return resultHead;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, null, null);

        node1.next = node2;
        node2.next = node3;

        node1.random = node2;
        node2.random = node2;
        node3.random = node2;

        Solution solution = new Solution();
        display(solution.copyRandomList(node1));
    }

    static void display(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
