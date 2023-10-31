package design;

import common.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    // 双向链表节点定义
    static class LinkNode {
        int key;
        int value;
        LinkNode next;
        LinkNode pre;

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkNode head;
    LinkNode tail;
    int capacity;
    int size;
    Map<Integer, LinkNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkNode(-1, -1);
        tail = new LinkNode(-2, -2);
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        LinkNode linkNode = cache.get(key);
        if (linkNode == null) {
            return -1;
        }
        moveToHead(linkNode);
        return linkNode.value;
    }

    public void put(int key, int value) {
        LinkNode linkNode = cache.get(key);
        if (linkNode != null) {
            linkNode.value = value;
            moveToHead(linkNode);
        } else {
            LinkNode node = new LinkNode(key, value);
            insertToHead(node);
            cache.put(key, node);
            size++;

            if (size > capacity) {
                LinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }

    }

    private LinkNode removeTail() {
        LinkNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private void removeNode(LinkNode node) {
        LinkNode pre = node.pre;
        LinkNode next = node.next;
        pre.next = next.next;
        next.pre = pre;
    }

    private void insertToHead(LinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(LinkNode node) {
        removeNode(node);
        insertToHead(node);
    }
}
