package design;

import java.util.HashMap;
import java.util.Map;

class AllOne {

    private Map<String, Node> keyNodeMap;

    private Node head;
    private Node tail;

    public AllOne() {
        keyNodeMap = new HashMap<>();

        // 双向链表，计数从小到大排序
        head = new Node("head", -1);
        tail = new Node("tail", Integer.MAX_VALUE);

        head.next = tail;
        tail.pre = head;
    }

    public void inc(String key) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value++;

            if (node.next != tail) {
                // 遍历找到第一个>=node的value的node
                Node tmp = node.next;
                while (tmp != tail && tmp.value < node.value) {
                    tmp = tmp.next;
                }
                // 从双向链表中删除node
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = null;
                node.pre = null;
                // 将node插入到tmp的前面一个节点的后面
                Node pre = tmp.pre;
                pre.next = node;
                node.pre = pre;
                node.next = tmp;
                tmp.pre = node;
            }
        } else {
            Node node = new Node(key, 1);
            keyNodeMap.put(key, node);
            // 插入到双向链表的头节点后面
            Node next = head.next;
            head.next = node;
            node.pre = head;
            node.next = next;
            next.pre = node;
        }
    }

    public void dec(String key) {
        if (!keyNodeMap.containsKey(key)) {
            return;
        }

        Node node = keyNodeMap.get(key);
        node.value--;

        // value减到0，则删除该key
        if (node.value == 0) {
            // map中remove
            keyNodeMap.remove(key);
            // 双向链表中remove该node
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            node.next = null;
            node.pre = null;
        } else {
            // value没减到0，则将该key排到小于value的节点后面
            if (node.pre != head && node.value < node.pre.value) {
                Node tmp = node.pre;
                while (tmp != head && tmp.value >= node.value) {
                    tmp = tmp.pre;
                }
                // 从双向链表中删除node
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = null;
                node.pre = null;
                // 将node插入到tmp后面
                Node next = tmp.next;
                tmp.next = node;
                node.pre = tmp;
                node.next = next;
                next.pre = node;
                node.next = next;
                next.pre = node;
            }
        }
    }

    public String getMaxKey() {
        return tail.pre.key;
    }

    public String getMinKey() {
        return head.next.key;
    }

    class Node {
        String key;
        int value;
        Node pre;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void display() {
        System.out.print(head.key + "=" + head.value + "\t");
        Node tmp = head.next;
        while (tmp != tail) {
            System.out.print(tmp.key + "=" + tmp.value + "\t");
            tmp = tmp.next;
        }
        System.out.print(tail.key + "=" + tail.value);
        System.out.print("\tmaxKey=" + getMaxKey());
        System.out.print("\tminKey=" + getMinKey());
        System.out.println("\tkeySet=" + keyNodeMap.keySet());
    }
}
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */