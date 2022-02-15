package list;

import common.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode faster = pre, slow = pre;
        while (n > 0) {
            faster = faster.next;
            n--;
        }

        while (faster.next != null) {
            faster = faster.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return pre.next;
    }
}
