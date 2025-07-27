package common;

public class DListNode {
    public int value;
    public DListNode pre;
    public DListNode next;

    public DListNode(int value) {
        this.value = value;
    }

    public DListNode(int value, DListNode pre, DListNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}
