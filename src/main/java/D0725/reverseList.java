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
class reverseList {

    public static void main(String[] args) {
        reverseList reverseList = new reverseList();
        ListNode head1 = new ListNode(10);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = reverseList.reverseList(head1);
        ListNodeUtils.display(node);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1->2->3->4
        ListNode newHead = reverseList(head.next);
        // reverse后，链表变为这样：1->2<-3<-4
        head.next.next = head; // 1<->2<-3<-4
        head.next = null;// 1<-2<-3<-4
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}