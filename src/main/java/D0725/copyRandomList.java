package D0725;/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


import model.v2.Node;

import java.util.HashMap;
import java.util.Map;

class copyRandomList {

    public static void main(String[] args) {
        copyRandomList copyRandomList = new copyRandomList();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;

        Node node = copyRandomList.copyRandomList(node1);
        System.out.println(node);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node dummy = new Node(-1);
        Node pre = dummy;
        Node p = head;

        Map<Node, Node> nodeMap = new HashMap<>();
        while (p != null) {
            Node newNode = new Node(p.val);
            nodeMap.put(p, newNode);
            pre.next = newNode;
            pre = newNode;
            p = p.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                Node node = nodeMap.get(p);
                Node node1 = nodeMap.get(p.random);
                node.random = node1;
            }
            p = p.next;
        }

        return dummy.next;
    }

}