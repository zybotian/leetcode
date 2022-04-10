package list;

import common.Interval;
import common.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode list = reverseList(head.next);
        ListNode tail = list;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return list;
    }

    public ListNode reverseListV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head, tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseListV3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseListV3(null, head);
    }

    private ListNode reverseListV3(ListNode headReversed, ListNode headWaitingReverse) {
        ListNode tmp = headWaitingReverse.next;
        headWaitingReverse.next = headReversed;
        return reverseListV3(headWaitingReverse, tmp);
    }
}
