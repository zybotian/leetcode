package list;

import common.ListNode;
import util.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.create(new int[]{3, 2, 0, -4});
        listNode.next.next.next.next = listNode.next;
        System.out.println(new DetectCycle().detectCycle(listNode));

        ListNode listNode2 = ListNodeUtils.create(new int[]{1, 2});
        listNode2.next.next = listNode2;
        System.out.println(new DetectCycle().detectCycle(listNode2));

        ListNode listNode3 = ListNodeUtils.create(new int[]{1});
        System.out.println(new DetectCycle().detectCycle(listNode3));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
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
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
    }
}
