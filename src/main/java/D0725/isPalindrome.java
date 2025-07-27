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
class isPalindrome {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        isPalindrome isPalindrome = new isPalindrome();
        System.out.println(isPalindrome.isPalindrome(head1));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return true;
        }

        ListNode middle = getMiddleNode(head);

        ListNode rightHead = middle.next;
        middle.next = null;
        ListNode node = reverseList(rightHead);

        ListNode p = head, q = node;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return q == null;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1->2->3->4
        ListNode newHead = reverseList(head.next);
        // 1->2<-3<-4
        head.next.next = head;
        // 1<-2<-3<-4
        head.next = null;
        return newHead;
    }
}