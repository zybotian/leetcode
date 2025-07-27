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
class sortList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(10);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(43);
        ListNode node5 = new ListNode(4);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        sortList sortList = new sortList();
        ListNode node = sortList.sortList(head1);
        ListNodeUtils.display(node);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddleNode(head);
        ListNode middleNext = middle.next;
        middle.next = null;

        return mergeTwoLists(sortList(head), sortList(middleNext));
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        ListNode p = list1, q = list2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                pre.next = p;
                pre = p;
                p = p.next;
            } else {
                pre.next = q;
                pre = q;
                q = q.next;
            }
        }

        if (p != null) {
            pre.next = p;
        }
        if (q != null) {
            pre.next = q;
        }

        return dummy.next;
    }
}