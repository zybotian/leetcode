package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    Map<Integer, Node> keyNodeMap;
    DoubleLinkList doubleLinkList;
    int maxSize;
    int count;

    public LRUCache2(int capacity) {
        keyNodeMap = new HashMap<>();
        doubleLinkList = new DoubleLinkList();
        maxSize = capacity;
        count = 0;
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        }

        Node node = keyNodeMap.get(key);
        doubleLinkList.remove(node);
        doubleLinkList.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            doubleLinkList.remove(node);
            doubleLinkList.addFirst(node);
        } else {
            count++;
            Node node = new Node(key, value, null, null);
            keyNodeMap.put(key, node);
            doubleLinkList.addFirst(node);
            if (count > maxSize) {
                Node removedNode = doubleLinkList.removeLast();
                keyNodeMap.remove(removedNode.key);
                count--;
            }
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    class DoubleLinkList {
        Node head;
        Node tail;

        public DoubleLinkList() {
            this.head = new Node(0, 0, null, null);
            this.tail = new Node(0, 0, null, null);
            head.next = tail;
            tail.pre = head;
        }

        public void remove(Node node) {
            if (node != null && head.next != tail && tail.pre != head) {
                Node pre = node.pre;
                Node next = node.next;
                pre.next = next;
                next.pre = pre;
            }
        }

        public void addFirst(Node node) {
            if (node != null) {
                Node next = head.next;
                head.next = node;
                node.pre = head;
                node.next = next;
                next.pre = node;
            }
        }

        public Node removeLast() {
            if (head.next != tail && tail.pre != head) {
                Node lastNode = tail.pre;
                remove(lastNode);
                return lastNode;
            }
            return null;
        }
    }
}
