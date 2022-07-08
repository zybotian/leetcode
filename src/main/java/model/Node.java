package model;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + (next != null ? next.val : "NULL") +
                ", random=" + (random != null ? random.val : "NULL") +
                '}';
    }
}