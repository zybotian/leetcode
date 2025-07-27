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
class addTwoNumbers {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);

        ListNode head2 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);


        head1.next = node1;
        node1.next = node2;
        node2.next = node3;

        head2.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;


        addTwoNumbers addTwoNumbers = new addTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers(head1, head2);
        ListNodeUtils.display(node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode p = l1, q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int num1 = p != null ? p.val : 0;
            int num2 = q != null ? q.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            pre.next = node;
            pre = node;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            pre.next = node;
        }
        return dummy.next;
    }
}