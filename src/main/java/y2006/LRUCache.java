package y2006;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    public class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;
    }

    Map<Integer, DLinkNode> map = new HashMap<>();
    int size;
    int capacity;
    DLinkNode head;
    DLinkNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        head.pre = null;
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            size++;
            addToHead(newNode);

            if (size > capacity) {
                DLinkNode tail = removeTail();
                map.remove(tail.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkNode node) {
        DLinkNode pre = node.pre;
        DLinkNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private void addToHead(DLinkNode newNode) {
        newNode.pre = head;
        newNode.next = head.next;
        head.next.pre = newNode;
        head.next = newNode;
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 11);
        System.out.println(lruCache.get(1));
        lruCache.put(2, 22);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 33);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */