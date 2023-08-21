package list;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (visited.contains(p)) {
                return true;
            }
            visited.add(p);
            p = p.next;
        }
        return false;
    }
}
