package y2006;

import common.Node;

import java.util.HashMap;
import java.util.Map;

public class copyRandomList {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> oldNewMap = new HashMap<>();
        Node p = head;
        Node dummy = new Node(0), cur = dummy;
        while (p != null) {
            Node node = new Node(p.val);
            oldNewMap.put(p, node);
            cur.next = node;
            cur = node;
            p = p.next;
        }
        p = head;
        while (p != null) {
            oldNewMap.get(p).random = oldNewMap.get(p.random);
            p = p.next;
        }
        return dummy.next;
    }
}
