package D0725;

import common.ListNode;
import util.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class removeNthFromEnd {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        removeNthFromEnd removeNthFromEnd = new removeNthFromEnd();
        ListNode node = removeNthFromEnd.removeNthFromEnd(head1, 2);
        ListNodeUtils.display(node);
        ListNode node1 = removeNthFromEnd.removeNthFromEnd(head1, 1);
        ListNodeUtils.display(node1);

        ListNode node11 = removeNthFromEnd.removeNthFromEnd(head1, 3);
        ListNodeUtils.display(node11);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = next.next;
        next.next = null;
        return dummy.next;
    }
}