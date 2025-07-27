package D0725;

import common.ListNode;
import model.v2.Node;
import util.ListNodeUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class detectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        detectCycle detectCycle = new detectCycle();
        System.out.println(detectCycle.detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p = head, q = slow;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (!visited.contains(p)) {
                visited.add(p);
                p = p.next;
            } else {
                return p;
            }
        }
        return null;
    }
}