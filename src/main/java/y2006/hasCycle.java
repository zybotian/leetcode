package y2006;

import common.ListNode;
import util.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

public class hasCycle {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.create(new int[]{1, 2, 3, 4, 5});
        listNode.next.next.next.next = listNode.next;
        hasCycle hasCycle = new hasCycle();
        System.out.println(hasCycle.hasCycle(listNode));
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }
}
