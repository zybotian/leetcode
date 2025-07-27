package D0725;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int cacheCapacity;
    private int cacheSize;
    private DListNode head;
    private DListNode tail;
    private Map<Integer, DListNode> cache;

    public LRUCache(int capacity) {
        cacheCapacity = capacity;
        head = new DListNode(-1, -1);
        tail = new DListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        DListNode dListNode = cache.get(key);
        if (dListNode != null) {
            moveListElementToHead(dListNode);
            return dListNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (cacheSize >= cacheCapacity) {
                // 从链表删除
                DListNode removed = removeLastNodeFromList();
                // 从cache删除
                cache.remove(removed.key);
                cacheSize--;
            }

            DListNode dListNode = new DListNode(key, value);
            cache.put(key, dListNode);
            cacheSize++;
            insertNoteToListHead(dListNode);
        } else {
            DListNode node = cache.get(key);
            node.value = value;
            moveListElementToHead(node);
        }
    }

    private DListNode removeNodeFromList(DListNode toRemove) {
        if (toRemove != null) {
            DListNode pre = toRemove.pre;
            DListNode next = toRemove.next;
            pre.next = next;
            next.pre = pre;
            toRemove.pre = null;
            toRemove.next = null;
            return toRemove;
        }
        return null;
    }

    private DListNode removeLastNodeFromList() {
        DListNode lastNode = tail.pre;
        return removeNodeFromList(lastNode);
    }

    private void insertNoteToListHead(DListNode dListNode) {
        if (dListNode != null) {
            DListNode firstNode = head.next;
            head.next = dListNode;
            dListNode.pre = head;
            dListNode.next = firstNode;
            firstNode.pre = dListNode;
        }
    }

    private void moveListElementToHead(DListNode dListNode) {
        DListNode removed = removeNodeFromList(dListNode);
        insertNoteToListHead(removed);
    }


    public static class DListNode {
        public int key;
        public int value;
        public DListNode pre;
        public DListNode next;

        public DListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */