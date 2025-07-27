package D0725;

import common.ListNode;
import util.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class getIntersectionNode {

    public static void main(String[] args) {
        getIntersectionNode getIntersectionNode = new getIntersectionNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode head1 = new ListNode(10);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head2 = new ListNode(20);
        head2.next = new ListNode(21);
        head2.next.next = new ListNode(22);
        head2.next.next.next = node3;

        ListNode intersectionNode = getIntersectionNode.getIntersectionNode(head1, head2);
        ListNodeUtils.display(intersectionNode);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getListLength(headA);
        int len2 = getListLength(headB);

        ListNode p1 = headA, p2 = headB;
        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff > 0 && p1 != null) {
                p1 = p1.next;
                diff--;
            }
        } else if (len1 < len2) {
            int diff = len2 - len1;
            while (diff > 0 && p2 != null) {
                p2 = p2.next;
                diff--;
            }
        }
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == p2 ? p1 : null;
    }

    private int getListLength(ListNode headA) {
        ListNode p = headA;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            set.add(p);
            p = p.next;
        }

        p = headB;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

}