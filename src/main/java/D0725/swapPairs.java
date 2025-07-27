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
class swapPairs {

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


        swapPairs swapPairs = new swapPairs();
        ListNode node = swapPairs.swapPairs(head1);
        ListNodeUtils.display(node);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode node = swapPairs(newHead.next);
        head.next = node;
        newHead.next = head;
        return newHead;
    }
}