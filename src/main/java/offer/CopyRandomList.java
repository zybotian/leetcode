package offer;

import model.Node;
import util.NodeUtils;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        Node node = copyRandomList(node1);
        NodeUtils.println(node);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node p = head;
        while (p != null) {
            Node clone = new Node(p.val);
            clone.next = p.next;
            p.next = clone;
            p = p.next.next;
        }

        Node p1 = head, p2 = head.next;
        while (p1 != null && p2 != null) {
            if (p1.random != null) {
                p2.random = p1.random.next;
            }
            p1 = p2.next;
            if (p1 != null) {
                p2 = p1.next;
            }
        }

        Node newHead = head.next;
        Node p3 = head, p4 = head.next;
        while (p3 != null && p4 != null) {
            p3.next = p4.next;
            p3 = p3.next;
            if (p3 != null) {
                p4.next = p3.next;
            }
            p4 = p4.next;
        }
        return newHead;
    }

    public static Node copyRandomListV2(Node head) {
        if (head == null) {
            return null;
        }

        Node dummy = new Node(0);
        Node current = dummy;
        Map<Node, Node> oldNewMap = new HashMap<>();

        Node p = head;
        while (p != null) {
            // 创建新节点
            Node node = new Node(p.val);
            // 构建旧节点和新节点关系map
            oldNewMap.put(p, node);
            // 构建next指针链
            current.next = node;
            current = node;
            p = p.next;
        }

        // 构建random指针链
        Node p1 = dummy.next;
        Node p2 = head;

        while (p1 != null) {
            p1.random = oldNewMap.get(p2.random);
            p1 = p1.next;
            p2 = p2.next;
        }

        return dummy.next;
    }
}
