package y2006;

import common.ListNode;
import util.ListNodeUtils;

public class removeNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.create(new int[]{1, 2, 3, 4, 5});
        removeNthFromEnd removeNthFromEnd = new removeNthFromEnd();
        ListNode listNode1 = removeNthFromEnd.removeNthFromEnd(listNode, 5);
        ListNodeUtils.display(listNode1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        ListNode fast=dummy, slow=dummy;
        dummy.next = head;

        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (n == len) {
            return head.next;
        }
        // 1->2->3->4->5
        p = head;
        for (int i = 0; i < len - n - 1; i++) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        return head;
    }
}
