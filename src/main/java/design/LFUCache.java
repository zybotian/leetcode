package design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author tianbo
 * @date 2019-04-15 http://ju.outofmemory.cn/entry/50447
 */
public class LFUCache {
    private Node head = null;
    // 缓存容量
    private int capacity = 0;
    // 一个hashmap保存key-value数据, 查询操作直接从该map中获取, 时间复杂度O(1)
    private Map<Integer, Integer> dataMap = null;
    // 一个hashmap保存key-node数据
    private Map<Integer, Node> nodeMap = null;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.dataMap = new HashMap<>();
        this.nodeMap = new HashMap<>();
    }

    public int get(int key) {
        if (dataMap.containsKey(key)) {
            // 缓存命中, 增加key的访问频次
            increaseFrequency(key);
            return dataMap.get(key);
        }
        // 缓存未命中的情况
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (dataMap.containsKey(key)) {
            // 缓存中已经有了这个key,相当于是更新缓存的操作
            dataMap.put(key, value);
            Node node = nodeMap.get(key);
            node.keys.remove(key);
            node.keys.add(key);
        } else {
            // 缓存中没有这个key
            if (dataMap.size() < capacity) {
                // 缓存还没有满,直接put即可
                dataMap.put(key, value);
            } else {
                // 缓存已经满了, 需要先删除一个元素
                removeOld();
                dataMap.put(key, value);
            }
            addToHead(key);
        }
        increaseFrequency(key);
    }

    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        nodeMap.put(key, head);
    }

    private void increaseFrequency(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);

        if (node.next == null) {
            node.next = new Node(node.count + 1);
            node.next.prev = node;
            node.next.keys.add(key);
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            Node tmp = new Node(node.count + 1);
            tmp.keys.add(key);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }

        nodeMap.put(key, node.next);
        if (node.keys.size() == 0) {
            remove(node);
        }
    }

    private void removeOld() {
        if (head == null) {
            return;
        }
        int old = 0;
        for (int n : head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) {
            remove(head);
        }
        nodeMap.remove(old);
        dataMap.remove(old);
    }

    private void remove(Node node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    class Node {
        // 频率
        public int count = 0;
        // 该频率下的key, 按访问顺序保存
        public LinkedHashSet<Integer> keys = null;

        public Node prev = null;
        public Node next = null;

        public Node(int count) {
            this.count = count;
            this.keys = new LinkedHashSet<>();
            this.prev = this.next = null;
        }
    }
}
