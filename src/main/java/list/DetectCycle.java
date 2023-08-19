package list;

import common.ListNode;
import util.ListNodeUtils;

import javax.swing.*;
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
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && slow != null && fast != slow) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        if (fast == null || slow == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        set.add(fast);
        ListNode curr = fast.next;
        while (curr != slow) {
            set.add(curr);
            curr = curr.next;
        }

        curr = head;
        while (!set.contains(curr)) {
            curr = curr.next;
        }
        return curr;
    }
}
