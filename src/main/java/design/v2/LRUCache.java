package design.v2;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    static class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    DLinkNode head, tail;
    int size;
    int capacity;
    Map<Integer, DLinkNode> cache;

    public LRUCache(int capacity) {
        head = new DLinkNode(-1, -1);
        tail = new DLinkNode(-2, -2);
        head.next = tail;
        tail.pre = head;

        size = 0;
        this.capacity = capacity;

        cache = new HashMap<>();
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 刚才访问过的元挪动到链表最前面
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);

        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            insertToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void insertToHead(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        DLinkNode pre = node.pre;
        DLinkNode next = node.next;
        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;
    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.pre;
        removeNode(node);
        return node;
    }


    private void moveToHead(DLinkNode node) {
        // 先从链表中删除
        removeNode(node);
        // 再头插法插入到链表中
        insertToHead(node);
    }
}